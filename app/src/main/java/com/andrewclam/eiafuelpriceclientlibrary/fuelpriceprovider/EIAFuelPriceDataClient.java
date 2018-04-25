package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.Manifest;
import android.accounts.NetworkErrorException;
import android.location.Address;
import android.net.Network;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;
import com.google.common.base.Joiner;
import com.google.common.base.Strings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.TestObserver;

/**
 * Concrete implementation of the {@link EIAFuelPriceDataClientApi}
 * TODO implement Retrofit to do getData() and data extraction steps
 * TODO strip out json key as constants
 */
public final class EIAFuelPriceDataClient implements EIAFuelPriceDataClientApi,
    FuelPriceDataProvider {

  // EIA API Key
  private static final String EIA_API_KEY =
      "8576274d08ef8c2e1d92e2abb1fdcba4";

  // Base URL for a EIA to find matching series id base on keyword (name)
  private static final String BASE_EIA_QUERY_SERIES_ID_BY_NAME_URL =
      "http://api.eia.gov/search/?search_term=name&search_value=";

  // Base URL for to query a EIA series id
  private static final String BASE_EIA_QUERY_DATA_SET_BY_SERIES_ID_URL =
      "http://api.eia.gov/series/?api_key=" +
          EIA_API_KEY +
          "&series_id=";

  // Default base URL to fallback to when region can't be matched
  // URL points to U.S National Average data
  private static final String EIA_SERIES_ID_DEFAULT_URL =
      "http://api.eia.gov/series/?api_key=" +
          EIA_API_KEY +
          "&series_id=PET.EMM_EPM0_PTE_NUS_DPG.W";

  @Nullable
  @VisibleForTesting
  FuelPriceData mCachedFuelPriceData;

  @VisibleForTesting
  boolean mCacheIsDirty = false;

  @NonNull
  private final EIAFuelPriceDataClient.Strategy mStrategy;

  private EIAFuelPriceDataClient() {
    mStrategy = new Strategy();
  }

  private static volatile EIAFuelPriceDataClient INSTANCE;

  /**
   * Returns the single instance of this class, creating it if necessary.
   *
   * @return the {@link EIAFuelPriceDataClient} instance
   */
  public static EIAFuelPriceDataClient getInstance() {
    if (INSTANCE == null) {
      synchronized (EIAFuelPriceDataClient.class) {
        if (INSTANCE == null) {
          INSTANCE = new EIAFuelPriceDataClient();
        }
      }
    }
    return INSTANCE;
  }

  /**
   * Used to force {@link #getInstance()} to create a new instance
   * next time it's called.
   */
  public static void destroyInstance() {
    INSTANCE = null;
  }

  @Override
  public void refresh() {
    mCacheIsDirty = true;
  }

  @NonNull
  @Override
  public Single<FuelPriceData> getPrice(@NonNull Address address) {
    // Return immediately if the in-memory cache is clean and has a value
    if (!mCacheIsDirty && mCachedFuelPriceData != null) {
      return Single.just(mCachedFuelPriceData);
    }

    return createSeriesIdRequestURL(address)
        .flatMap(this::getData)
        .flatMap(this::extractDataSetSeriesId)
        .flatMap(this::createFuelDataRequestURL)
        .flatMap(this::getData)
        .flatMap(this::extractFuelPriceData);
  }

  @Override
  public void getPrice(@NonNull Address address, @NonNull OnCompleteCallback callback) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    Disposable disposable = getPrice(address).subscribe(
        callback::onSuccess,
        callback::onError
    );
    compositeDisposable.add(disposable);
  }

  @NonNull
  @Override
  public Single<FuelPriceData> extractFuelPriceData(@NonNull String jsonresponse) {
    return mStrategy.extractFuelPriceData(jsonresponse);
  }

  @NonNull
  @Override
  public Single<String> createFuelDataRequestURL(@NonNull String seriesId) {
    return mStrategy.createFuelDataRequestURL(seriesId);
  }

  @NonNull
  @Override
  public Single<String> extractDataSetSeriesId(@NonNull String jsonResponse) {
    return mStrategy.extractDataSetSeriesId(jsonResponse);
  }

  @NonNull
  @Override
  public Single<String> getData(@NonNull String requestURL) {
    return mStrategy.getData(requestURL);
  }

  @NonNull
  @Override
  public Single<String> createSeriesIdRequestURL(@NonNull Address address) {
    return mStrategy.createSeriesIdRequestURL(address);
  }

  /**
   * Internal strategy class that provides the concrete implementations
   */
  private final class Strategy implements EIAFuelPriceDataClientApi {
    // LOG TAG
    private final String TAG = Strategy.class.getSimpleName();

    /**
     * Private constructor to prevent external instantiation
     * other than the direct enclosing class
     */
    private Strategy() {
    }

    @RequiresPermission(Manifest.permission.INTERNET)
    @NonNull
    public Single<FuelPriceData> extractFuelPriceData(@NonNull String jsonResponse) {
      return Single.create(emitter -> {
        if (Strings.isNullOrEmpty(jsonResponse)) {
          emitter.onError(new NoSuchElementException("unable to parse FuelPriceData from empty json"));
          return;
        }

        // Create an instance of the model to hold data
        FuelPriceData data = new FuelPriceData();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
          // 1) Convert SAMPLE_JSON_RESPONSE String into a JSONObject
          JSONObject rootJsonResponse = new JSONObject(jsonResponse);

          // 2) Extract "series" JSONArray from root
          JSONArray seriesJsonArray = rootJsonResponse.getJSONArray("series");

          // 3) The "series" JSON array to get the dataJsonArray,
          // the array it will just have one object when only one series is requested, so just set at 0
          JSONObject currentSeriesJsonObject = seriesJsonArray.getJSONObject(0);

          // 4) Assign the series ID and dataSetName of the returned json, for verification
          String seriesID = currentSeriesJsonObject.getString("series_id");
          String dataSetName = currentSeriesJsonObject.getString("name");

          // 5) Reference the data json array where all the data is
          JSONArray dataJsonArray = currentSeriesJsonObject.getJSONArray("data");

          // 6) Reference the latest fuel price, get the first element in the array
          JSONArray fuelPriceJsonArray = dataJsonArray.getJSONArray(0);

          // 7) Parse the latest fuel price,
          // date is the element at index 0,
          // and price is at index 1
          long updateTimeStamp = fuelPriceJsonArray.getLong(0);
          double gasPrice = fuelPriceJsonArray.getDouble(1);

          // 8) Assign the extracted data into a gas price item
          data.setDataSetId(seriesID);
          data.setDataSetName(dataSetName);
          data.setPrice(gasPrice);
          data.setUpdateTimeStamp(updateTimeStamp);

        } catch (JSONException e) {
          // If an error is thrown when executing any of the above statements in the "try" block,
          // catch the exception here, so the app doesn't crash. Print a log message
          // with the message from the exception.
          Log.e(TAG, "Problem parsing the gas retail prices JSON results", e);
          emitter.onError(e);
          return;
        }

        emitter.onSuccess(data);

      });
    }

    @NonNull
    @Override
    public Single<String> createFuelDataRequestURL(@NonNull String seriesId) {
      return Single.create(emitter -> {
        if (Strings.isNullOrEmpty(seriesId) || !seriesId.contains("PET.EMM_EPM0")) {
          emitter.onError(new IllegalArgumentException("Invalid EIA data set series id"));
        } else {
          emitter.onSuccess(BASE_EIA_QUERY_DATA_SET_BY_SERIES_ID_URL + seriesId);
        }
      });
    }

    @NonNull
    @Override
    public Single<String> extractDataSetSeriesId(@NonNull String jsonResponse) {
      return Single.create(emitter -> {
        // If the JSON string is empty or null, then return early.
        if (Strings.isNullOrEmpty(jsonResponse)) {
          emitter.onError(new IllegalArgumentException("no data, jsonResponse can't be empty."));
          return;
        }

        // Create a string variable to store the retrieved seriesId
        String seriesId;

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
          // 1) Convert SAMPLE_JSON_RESPONSE String into a JSONObject
          JSONObject rootJsonResponse = new JSONObject(jsonResponse);

          // 2) Get the response object
          JSONObject queryResponseJsonObject = rootJsonResponse.getJSONObject("response");

          // 3) Get the docs array
          JSONArray dataJsonArray = queryResponseJsonObject.getJSONArray("docs");

          // 4) Get the most likely candidate
          JSONObject dataJsonObject = dataJsonArray.getJSONObject(0);

          // 5) Parse the series_id
          seriesId = dataJsonObject.getString("series_id");

        } catch (JSONException e) {
          // If an error is thrown when executing any of the above statements in the "try" block,
          // catch the exception here, so the app doesn't crash. Print a log message
          // with the message from the exception.
          Log.e(TAG, "Problem parsing the series id from the JSON results", e);
          emitter.onError(e);
          return;
        }

        if (Strings.isNullOrEmpty(seriesId)) {
          emitter.onError(new IllegalArgumentException("series id can't be null or empty"));
        } else {
          // Return the series id
          emitter.onSuccess(seriesId);
        }
      });
    }

    @NonNull
    @Override
    public Single<String> createSeriesIdRequestURL(@NonNull Address address) {
      return Single.create(emitter -> {
        String dataSetName = getDataSetName(address);
        String requestUrl = BASE_EIA_QUERY_SERIES_ID_BY_NAME_URL.concat(dataSetName);
        emitter.onSuccess(requestUrl);
      });
    }

    /**
     * Generate an exact gasoline data set name base on region, required by
     * {@link #createSeriesIdRequestURL(Address)}
     * <p>
     * see https://www.eia.gov/opendata/qb.php?category=240839&sdid=PET.EMM_EPM0_PTE_SCA_DPG.W
     * ex. California All Grades All Formulations Retail Gasoline Prices, Weekly
     * <p>
     * mRegionName: East Coast (as Determined by the PADD1 Region Code)
     * mGrade:  Regular, MidGrade, Premium, All Grades
     * mFormulation: All Formulations, Reformulated , Conventional
     * mCommodityType: Retail Gasoline Prices,
     * mUpdateFreq: Weekly, Monthly, Annually
     *
     * @param address
     * @return a corresponding data set's name at EIA
     */
    @NonNull
    private String getDataSetName(@NonNull Address address) {
      // Request data set name concat elements
      String mRegionName = getRegionFromAddress(address); // ex. California
      String mGrade = "All Grades";
      String mFormulation = "All Formulations";
      String mMarketType = "Retail Gasoline Prices";
      String mUpdateFreq = ", Weekly";

      String[] dataSetNameFrag = new String[]{
          mRegionName,
          mGrade,
          mFormulation,
          mMarketType,
          mUpdateFreq
      };

      return Joiner.on("%20")
          .skipNulls()
          .join(dataSetNameFrag)
          .replace(" ", "%20");
    }

    /**
     * TODO implement region matcher algorithm
     *
     * @return an encoded region that has a corresponding data set at source api
     */
    @NonNull
    private String getRegionFromAddress(@NonNull Address address) {
      return "California";
    }

    @NonNull
    @Override
    public Single<String> getData(@NonNull String requestURL) {
      return Single.create(emitter -> {
        // Create URL object
        URL url;
        url = new URL(requestURL);
        String jsonResponse = makeHttpRequest(url);
        emitter.onSuccess(jsonResponse);
      });
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     * This establishes the necessary http connection to the server
     * This method takes the argument url
     * This methods makes calls to {@link #readFromStream(InputStream)}
     */
    @NonNull
    @RequiresPermission(Manifest.permission.INTERNET)
    private String makeHttpRequest(@NonNull URL url) throws IOException, NetworkErrorException {
      String jsonResponse = "";
      HttpURLConnection urlConnection = null;
      InputStream inputStream = null;

      try {
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        // If the request was successful (response code 200),
        // then read the input stream and parse the response.
        if (urlConnection.getResponseCode() == 200) {
          inputStream = urlConnection.getInputStream();
          jsonResponse = readFromStream(inputStream);
        } else {
          throw new NetworkErrorException("Error response code: "
              + urlConnection.getResponseCode());
        }
      } finally {
        if (urlConnection != null) {
          urlConnection.disconnect();
        }
        if (inputStream != null) {
          inputStream.close();
        }
      }
      return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    @NonNull
    private String readFromStream(@Nullable InputStream inputStream) throws IOException {
      StringBuilder output = new StringBuilder();
      if (inputStream != null) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,
            Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        while (line != null) {
          output.append(line);
          line = reader.readLine();
        }
      }
      return output.toString();
    }
  }
}

