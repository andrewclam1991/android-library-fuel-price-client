package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;

import com.google.common.base.Optional;

import io.reactivex.Single;

/**
 * Exposes public pricing data base on a provided region or a specific location
 */
interface FuelPriceDataProvider {

  /**
   * Reactive RxJava interface to get price by the provided {@link Address}
   *
   * @param address address for getting its regional price data
   * @return an observable result that when onSuccess, returns the fuel price per volume
   */
  @NonNull
  Single<Double> getPrice(@NonNull Address address);

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

    void onReceived(@NonNull Double price);

    void onError(@NonNull Throwable throwable);

  }

}