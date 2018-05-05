package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import android.location.Address;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.gaspriceprovider.DefaultProviderStrategy;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.gaspriceprovider.ProviderStrategy;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.gaspriceprovider.NullProviderStrategy;
import com.google.common.base.Strings;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Concrete implementation of the {@link ProviderStrategy}
 * TODO implement Retrofit to do getData() and data extraction steps
 * TODO strip out json key as constants
 */
public final class GasPriceProvider implements ProviderStrategy, EIADataProvider {

  // EIA API Key
  @NonNull
  private String mAPIKey;

  @Nullable
  @VisibleForTesting
  FuelPriceData mCachedFuelPriceData;

  @VisibleForTesting
  boolean mCacheIsDirty = false;

  @NonNull
  private ProviderStrategy mProviderStrategy;

  private static volatile GasPriceProvider INSTANCE;

  /**
   * Returns the single instance of this class, creating it if necessary.
   *
   * @return the {@link GasPriceProvider} instance
   */
  public static GasPriceProvider getInstance() {
    if (INSTANCE == null) {
      synchronized (GasPriceProvider.class) {
        if (INSTANCE == null) {
          INSTANCE = new GasPriceProvider();
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

  private GasPriceProvider() {
    mProviderStrategy = new NullProviderStrategy();
    mAPIKey = "";
  }

  @Override
  public void refresh() {
    mCacheIsDirty = true;
  }

  @Override
  public void setApiKey(@NonNull String apiKey) {
    mAPIKey = apiKey;
    mProviderStrategy = new DefaultProviderStrategy(apiKey);
  }

  @NonNull
  @Override
  public Single<FuelPriceData> getPrice(@NonNull Address address) {
    // Check API Key
    if (Strings.isNullOrEmpty(mAPIKey) || mProviderStrategy instanceof NullProviderStrategy) {
      return Single.error(new IllegalArgumentException("No api key set, did you call setApiKey()?"));
    }

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
    return mProviderStrategy.extractFuelPriceData(jsonresponse);
  }

  @NonNull
  @Override
  public Single<String> createFuelDataRequestURL(@NonNull String seriesId) {
    return mProviderStrategy.createFuelDataRequestURL(seriesId);
  }

  @NonNull
  @Override
  public Single<String> extractDataSetSeriesId(@NonNull String jsonResponse) {
    return mProviderStrategy.extractDataSetSeriesId(jsonResponse);
  }

  @NonNull
  @Override
  public Single<String> getData(@NonNull String requestURL) {
    return mProviderStrategy.getData(requestURL);
  }

  @NonNull
  @Override
  public Single<String> createSeriesIdRequestURL(@NonNull Address address) {
    return mProviderStrategy.createSeriesIdRequestURL(address);
  }
}

