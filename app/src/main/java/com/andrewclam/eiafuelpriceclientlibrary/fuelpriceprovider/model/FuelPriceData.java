package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.model;

/**
 * TODO Use retrofit here to consume the API data
 * Model to hold the a price data point, and its containing data set information
 */
public class FuelPriceData {
  private String dataSetId;
  private String dataSetName;
  private double price;
  private long updateTimeStamp;

  public FuelPriceData() {
  }

  /**
   * Gets the price
   * @return the price of the fuel
   */
  public double getPrice() {
    return price;
  }

  /**
   * Persists the price
   * @param price price of the fuel
   */
  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Gets the data set last updated time stamp at the api source
   * @return the time stamp when the data set was last updated at source
   */
  public long getUpdateTimeStamp() {
    return updateTimeStamp;
  }

  /**
   * Persists the last updated timestamp by api source
   * @param updateTimeStamp the time stamp when the data set was updated
   */
  public void setUpdateTimeStamp(long updateTimeStamp) {
    this.updateTimeStamp = updateTimeStamp;
  }

  /**
   * Gets the unique id of the data set that this data belongs to
   * @return the data set id
   */
  public String getDataSetId() {
    return dataSetId;
  }

  /**
   * Persists the unique id of the data set that this data belongs to
   * @param dataSetId
   */
  public void setDataSetId(String dataSetId) {
    this.dataSetId = dataSetId;
  }

  /**
   * Gets the readable name of the data set that his data belongs to
   * @return the name of the data set
   */
  public String getDataSetName() {
    return dataSetName;
  }

  /**
   * Persists the readable name of the data set from the service api
   * @param dataSetName the name of the data set from the service api
   */
  public void setDataSetName(String dataSetName) {
    this.dataSetName = dataSetName;
  }
}
