# FuelPriceClientLibrary
Simple Android client library for getting current regional retail gas prices from U. S. Energy Information Administration public data sets.

### How to use ###

#### 1. Get an instance of the FuelPriceDataProvider ####
```
private FuelPriceDataProvider mProvider
...
mProvider = EIAFuelPriceDataProvider.getInstance();
```

#### 2. The library offers two simple ways to get gas price results: ####

##### receive result in a callback: #####
- call 'getPrice()' and pass it an 'Address' argument and pass it a 'FuelPriceDataProvider.OnCompleteCallback()'.
```
mProvider.getPrice(address, new FuelPriceDataProvider.OnCompleteCallback() {
      @Override
      public void onSuccess(@NonNull Double price) {
        // successfully got a price
      }

      @Override
      public void onError(@NonNull Throwable throwable) {
        // fatal error occured, handle accordingly
      }
    });
```
- Note: The query operation runs on the IO thread, callback methods will be called on the UI thread

##### (RxJava) receive result with a Single\<Double> observable: #####
If you are familiar with RxJava, 'FuelPriceDataProvider' provides a 'Single\<Double>' that you can manage or integrate into your existing observable chain.

```
Single<Double> SinglePriceResult = getPrice(address).subscribeWith()....;
  
```

### Development Environment ###

* Android Studio 3.1.2
* minSdkVersion = 16
* targetSdkVersion = 27
* compileSdkVersion = 27

--------------------
### Dependencies ###

* Android Support Libraries v27.1.1
* Guava v24.1-android
* RxJava v2.1.12
* RxAndroid v2.0.2
* jUnit v4.12
* Mockito v2.18.13
