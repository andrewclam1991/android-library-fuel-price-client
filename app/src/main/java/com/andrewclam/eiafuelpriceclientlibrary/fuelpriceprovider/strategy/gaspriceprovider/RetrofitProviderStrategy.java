package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.gaspriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;

import io.reactivex.Single;

// TODO implement a retrofit strategy for consuming the api
public class RetrofitProviderStrategy implements ProviderStrategy {
  @NonNull
  @Override
  public Single<FuelPriceData> extractFuelPriceData(@NonNull String jsonResponse) {
    return null;
  }

  @NonNull
  @Override
  public Single<String> createFuelDataRequestURL(@NonNull String seriesId) {
    return null;
  }

  @NonNull
  @Override
  public Single<String> extractDataSetSeriesId(@NonNull String jsonResponse) {
    return null;
  }

  @NonNull
  @Override
  public Single<String> getData(@NonNull String requestURL) {
    return null;
  }

  @NonNull
  @Override
  public Single<String> createSeriesIdRequestURL(@NonNull Address address) {
    return null;
  }
}
