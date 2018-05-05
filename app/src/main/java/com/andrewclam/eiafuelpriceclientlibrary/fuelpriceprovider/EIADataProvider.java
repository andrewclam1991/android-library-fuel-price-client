package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;

import io.reactivex.Single;

/**
 * Exposes public pricing data base on a provided region or a specific location
 */
public interface EIADataProvider {

  /**
   * Note: Client must supply an apiKey before querying the EIA data set, otherwise
   * an error will occur.
   *
   * register with EIA to get one at https://www.eia.gov/opendata/register.php
   * @param apiKey the EIA Open Data apiKey
   */
  void setApiKey(@NonNull String apiKey);

  /**
   * Reactive RxJava interface to get price by the provided {@link Address}
   *
   * @param address address for getting its regional price data
   * @return an observable result that when onSuccess, returns the fuel price per volume
   */
  @NonNull
  Single<FuelPriceData> getPrice(@NonNull Address address);

  /**
   * Call-back style interface to get fuel price by the provided {@link Address}
   *
   * @param address address for getting its regional price data
   */
  void getPrice(@NonNull Address address, @NonNull OnCompleteCallback callback);

  /**
   * Clears cached prices and forces next fetch to get fresh data from its
   * service api
   */
  void refresh();

  interface OnCompleteCallback {

    void onSuccess(@NonNull FuelPriceData data);

    void onError(@NonNull Throwable throwable);

  }

}