package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;

import org.json.JSONException;

import io.reactivex.Single;

/**
 * EIA specific client Api
 * see public data sets at
 * https://www.eia.gov/petroleum/gasdiesel/
 */
interface EIAFuelPriceDataClientApi {

  /**
   * Extracts data from the provided {@code jsonResponse} into a {@link FuelPriceData}
   *
   * @param jsonResponse JSON Response that contains the fuel price data
   * @return an observable {@link Single} that when subscribe to, it either:
   * emits onSuccess with the current {@link FuelPriceData}
   * or
   * emits onError with following possible exceptions:
   * {@link java.util.NoSuchElementException} when the {@code jsonResponse} is empty
   * {@link JSONException} when the {@code jsonResponse} can't be parsed
   */
  @NonNull
  Single<FuelPriceData> extractFuelPriceData(@NonNull String jsonResponse);

  @NonNull
  Single<String> createFuelDataRequestURL(@NonNull String seriesId);

  /**
   * Extracts data set series id from the provided {@code jsonResponse, required
   * by the {{@link #createFuelDataRequestURL(String seriesId)}}
   *
   * @param jsonResponse JSON Reponse that contains the data set series id.
   * @return an observable {@link Single} that when subcribed to, it either:
   * emits onSuccess with the matching data set series id as a {@link String}
   * or
   * emits onError with the following possible exceptions:
   * TBD
   */
  @NonNull
  Single<String> extractDataSetSeriesId(@NonNull String jsonResponse);

  /**
   * Makes a web request to get data with the provided {@code requestIDURL}
   * @param requestURL the formed url for querying the
   * @return an observable {@link Single} that when subscribed to, it either:
   * emits onSuccess with a JSONResponse
   * or
   * emits onError with the following possible exceptions:
   * TBD
   */
  @NonNull
  Single<String> getData(@NonNull String requestURL);

  /**
   * Matches the provided {@code address} with a coded data set name
   *
   * @param address
   * @return an observable {@link Single} that when subscribed to, it either"
   * emits onSuccess when a dataSet name match is found
   * or
   */
  @NonNull
  Single<String> createSeriesIdRequestURL(@NonNull Address address);
}
