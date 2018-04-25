package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.Manifest;
import android.location.Address;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;

import com.google.common.base.Strings;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * EIA specific client Api
 * see public data set
 * https://www.eia.gov/petroleum/gasdiesel/
 */
interface EIAFuelPriceDataProviderApi {

  @NonNull
  Single<Double> getFuelPrice(@NonNull String jsonResponse);

  @NonNull
  Single<String> getData(@NonNull String requestURL);

  @NonNull
  Single<String> getRequestURL(@NonNull String seriesId);

  @NonNull
  Single<String> getDataSetSeriesId(@NonNull Address address);
}

/**
 * Concrete implementation of the {@link EIAFuelPriceDataProviderApi}
 * TODO implement Retrofit to cleanup network setup and json parsing
 */
final class EIAFuelPriceDataProvider implements EIAFuelPriceDataProviderApi, FuelPriceDataProvider {

  // EIA API Key
  private static final String EIA_API_KEY =
      "YOUR_API_KEY_HERE";

  // Base URL for a EIA to find matching series id base on keyword (name)
  private static final String BASE_EIA_DATA_SET_QUERY_URL =
      "http://api.eia.gov/search/?search_term=name&search_value=";

  // Base URL for to query a EIA series id
  private static final String BASE_EIA_QUERY_BY_SERIES_ID_URL =
      "http://api.eia.gov/series/?api_key=" +
          EIA_API_KEY +
          "&series_id=";

  // Default base URL to fallback to when region can't be matched
  // URL points to U.S National Average data
  private static final String EIA_SERIES_ID_DEFAULT_URL =
      "http://api.eia.gov/series/?api_key=" +
          EIA_API_KEY +
          "&series_id=PET.EMM_EPM0_PTE_NUS_DPG.W";

  @VisibleForTesting
  Double mCachedPrice;

  @VisibleForTesting
  boolean mCacheIsDirty = false;

  @NonNull
  private final EIAFuelPriceDataProvider.Strategy mStrategy;

  private EIAFuelPriceDataProvider() {
    mStrategy = new Strategy();
  }

  private static volatile EIAFuelPriceDataProvider INSTANCE;

  public static EIAFuelPriceDataProvider getInstance() {
    if (INSTANCE == null) {
      synchronized (EIAFuelPriceDataProvider.class) {
        if (INSTANCE == null) {
          INSTANCE = new EIAFuelPriceDataProvider();
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public void refresh() {
    mCacheIsDirty = true;
  }

  @NonNull
  @Override
  public Single<Double> getPrice(@NonNull Address address) {
    // Return immediately if the in-memory cache is clean and has a value
    if (!mCacheIsDirty && mCachedPrice > 0) {
      return Single.just(mCachedPrice);
    }

    return getDataSetSeriesId(address)
        .flatMap(this::getRequestURL)
        .flatMap(this::getData)
        .flatMap(this::getFuelPrice);
  }

  @Override
  public void getPrice(@NonNull Address address, @NonNull OnCompleteCallback callback) {
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    Disposable disposable = getPrice(address).subscribe(
        callback::onReceived,
        callback::onError
    );
    compositeDisposable.add(disposable);
  }

  @NonNull
  @Override
  public Single<Double> getFuelPrice(@NonNull String jsonresponse) {
    return mStrategy.getFuelPrice(jsonresponse);
  }

  @NonNull
  @Override
  public Single<String> getData(@NonNull String requestURL) {
    return mStrategy.getData(requestURL);
  }

  @NonNull
  @Override
  public Single<String> getRequestURL(@NonNull String seriesId) {
    return mStrategy.getRequestURL(seriesId);
  }

  @NonNull
  @Override
  public Single<String> getDataSetSeriesId(@NonNull Address address) {
    return mStrategy.getDataSetSeriesId(address);
  }

  /**
   * internal strategy class that provides the concrete implementations
   */
  private final class Strategy implements EIAFuelPriceDataProviderApi {
    // LOG TAG
    private final String TAG = Strategy.class.getSimpleName();

    /**
     * Private constructor to prevent external instantiation
     * other than the direct enclosing class
     */
    private Strategy() {
    }

    @NonNull
    public Single<Double> getFuelPrice(@NonNull String data) {
      return Single.create(emitter -> {
        if (Strings.isNullOrEmpty(data)) {
          emitter.onError(new IllegalArgumentException("fuel data is empty"));
        } else {
          emitter.onSuccess(0.0);
        }
      });
    }

    @RequiresPermission(Manifest.permission.INTERNET)
    @NonNull
    public Single<String> getData(@NonNull String requestURL) {
      return Single.create(emitter -> {

        // TODO USE VOLLEY OR RETROFIT HERE FOR JSON parsing

      });
    }

    @NonNull
    public Single<String> getRequestURL(@NonNull String seriesId) {
      return Single.create(emitter -> {
        if (Strings.isNullOrEmpty(seriesId) || !seriesId.contains("PET.EMM_EPM0")) {
          emitter.onError(new IllegalArgumentException("Invalid EIA data set series id"));
        } else {
          emitter.onSuccess(BASE_EIA_QUERY_BY_SERIES_ID_URL + seriesId);
        }
      });
    }

    /**
     * Method to get the required series id string, required by {@link #getRequestURL(String)}
     * Implementation uses EIA search api to get the specific EIA base on the
     * given {@code address} argument.
     *
     * @param address the supplied {@code address} to find the matching series id for
     * @return the specific series id that corresponds to the {@code address}
     */
    @RequiresPermission(Manifest.permission.INTERNET)
    @NonNull
    public Single<String> getDataSetSeriesId(@NonNull Address address) {
      return Single.create(emitter -> {
        String dataSetName = getGasolineDataSetName(address);

        // Concat the root search url with the parameter dataSetName
        String requestUrl = BASE_EIA_DATA_SET_QUERY_URL.concat(dataSetName);

        // Create URL object
        URL url;
        try {
          url = new URL(requestUrl);
        }catch (MalformedURLException e){
          emitter.onError(e);
          return;
        }

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse;
        try {
          jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
          Log.e(TAG, "Error closing input stream", e);
          emitter.onError(e);
          return;
        }

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

    /**
     * Generate an exact gasoline data set name base on region, required by
     * {@link #getDataSetSeriesId(Address)}
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
    private String getGasolineDataSetName(@NonNull Address address) {
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

      return TextUtils.join("%20", dataSetNameFrag).replace(" ", "%20");
    }

    /**
     * TODO implement region matcher to query persistent database instead
     * @param address
     * @return an encoded region that has a corresponding dataset
     */
    @NonNull
    private String getRegionFromAddress(@NonNull Address address) {
      return null;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     * This establishes the necessary http connection to the server
     * This method takes the argument url
     * This methods makes calls to {@link #readFromStream(InputStream)}
     */
    @NonNull
    @RequiresPermission(Manifest.permission.INTERNET)
    private String makeHttpRequest(@NonNull URL url) throws IOException {
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
          Log.e(TAG, "Error response code: " + urlConnection.getResponseCode());
        }
      } catch (IOException e) {
        Log.e(TAG, "Problem retrieving the JSON results.", e);
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
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
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

