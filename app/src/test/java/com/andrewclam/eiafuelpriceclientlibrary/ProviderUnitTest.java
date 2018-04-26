package com.andrewclam.eiafuelpriceclientlibrary;

import android.location.Address;
import android.support.annotation.NonNull;
import android.util.Log;

import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.GasolinePriceDataProvider;
import com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.EIADataProvider;
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

  /**
   * Set a valid api key here for testing
   */
  @NonNull
  private final String VALID_API_KEY = "";

  @NonNull
  private final String INVALID_API_KEY = "123456abcdef";

  private EIADataProvider mProvider;

  private Address mTestAddress;

  @Before
  public void setupProvider(){
    mProvider = GasolinePriceDataProvider.getInstance();
    mTestAddress = new Address(Locale.getDefault());
  }

  @After
  public void cleanupProvider(){
    GasolinePriceDataProvider.destroyInstance();
  }

  @Test
  public void getPrice_usesRxJava(){
    // Given that a valid api key is provided
    mProvider.setApiKey(VALID_API_KEY);
    // and that the provider starts off fresh
    mProvider.refresh();

    // When a testSubscriber starts a subscription
    TestObserver<FuelPriceData> testSubscriber = new TestObserver<>();
    mProvider.getPrice(mTestAddress).subscribe(testSubscriber);

    // Verify that the testSubscriber received a single value
    // and that it has not received any errors.
    testSubscriber.assertValueCount(1);
    testSubscriber.assertNoErrors();
  }

}