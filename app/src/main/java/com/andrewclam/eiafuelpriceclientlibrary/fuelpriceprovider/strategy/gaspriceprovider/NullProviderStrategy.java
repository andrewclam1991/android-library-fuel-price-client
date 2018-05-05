package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.gaspriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;

import io.reactivex.Single;

public class NullProviderStrategy implements ProviderStrategy {
  @NonNull
  @Override
  public Single<FuelPriceData> extractFuelPriceData(@NonNull String jsonResponse) {
    return Single.error(new UnsupportedOperationException("No strategy is set"));
  }

  @NonNull
  @Override
  public Single<String> createFuelDataRequestURL(@NonNull String seriesId) {
    return Single.error(new UnsupportedOperationException("No strategy is set"));
  }

  @NonNull
  @Override
  public Single<String> extractDataSetSeriesId(@NonNull String jsonResponse) {
    return Single.error(new UnsupportedOperationException("No strategy is set"));
  }

  @NonNull
  @Override
  public Single<String> getData(@NonNull String requestURL) {
    return Single.error(new UnsupportedOperationException("No strategy is set"));
  }

  @NonNull
  @Override
  public Single<String> createSeriesIdRequestURL(@NonNull Address address) {
    return Single.error(new UnsupportedOperationException("No strategy is set"));
  }
}
