package com.andrewclam.eiafuelpriceclientlibrary;

import android.location.Address;
import android.support.annotation.NonNull;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.EIAFuelPriceDataClient;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.FuelPriceDataProvider;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model.FuelPriceData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.Locale;

import io.reactivex.observers.TestObserver;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class ProviderUnitTest {

  private FuelPriceDataProvider mProvider;

  private Address mTestAddress;

  @Before
  public void setupProvider(){
    mProvider = EIAFuelPriceDataClient.getInstance();
    mTestAddress = new Address(Locale.getDefault());
  }

  @After
  public void cleanupProvider(){
    EIAFuelPriceDataClient.destroyInstance();
  }

  @Test
  public void getPrice_usesRxJava(){
    // Given that the provider starts off fresh
    mProvider.refresh();

    // When a testSubscriber starts a subscription
    TestObserver<FuelPriceData> testSubscriber = new TestObserver<>();
    mProvider.getPrice(mTestAddress).subscribe(testSubscriber);

    // Verify that the testSubscriber received a single value
    // and that it has not received any errors.
    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoErrors();
  }

  @Test
  public void getPrice_usesCallback(){
    // Given that the provider starts off fresh
    mProvider.refresh();

    // When a getPrice is called with a callback
    mProvider.getPrice(mTestAddress, new FuelPriceDataProvider.OnCompleteCallback() {
      @Override
      public void onSuccess(@NonNull FuelPriceData data) {

      }

      @Override
      public void onError(@NonNull Throwable throwable) {

      }
    });

  }

}