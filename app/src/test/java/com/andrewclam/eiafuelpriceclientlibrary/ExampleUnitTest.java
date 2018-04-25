package com.andrewclam.eiafuelpriceclientlibrary;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.EIAFuelPriceDataProvider;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.FuelPriceDataProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
  private FuelPriceDataProvider mProvider;

  @Before
  public void setupProvider(){
    mProvider = EIAFuelPriceDataProvider.getInstance();
  }

  @After
  public void cleanupProvider(){
    EIAFuelPriceDataProvider.destroyInstance();
  }

  @Test
  public void test(){
    Address address = new Address(Locale.getDefault());
    mProvider.getPrice(address, new FuelPriceDataProvider.OnCompleteCallback() {
      @Override
      public void onSuccess(@NonNull Double price) {
        // get price here as a double
      }

      @Override
      public void onError(@NonNull Throwable throwable) {
        // get a throwable error
      }
    });
  }
}