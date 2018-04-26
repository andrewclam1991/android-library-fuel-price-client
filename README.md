# FuelPriceClientLibrary

Simple Android client library for getting current regional retail gas prices from U. S. Energy 
Information Administration (EIA) public data sets.

### Requirements ###
* minBuildToolsVersion TBD
* minJavaVersion 1.8
* minAndroidSdkVersion 16
=======
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