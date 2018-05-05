package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher;

import android.location.Address;
import android.support.annotation.NonNull;

/**
 * MatcherStrategy class that defines the region matcher responsibilities
 */
public interface MatcherStrategy {
  /**
   * Strategy to match an provided {@link Address} to
   * a predefined region
   * @param address address
   * @return the corresponding coded region.
   */
  @NonNull
  String matchRegion (@NonNull Address address);
}
