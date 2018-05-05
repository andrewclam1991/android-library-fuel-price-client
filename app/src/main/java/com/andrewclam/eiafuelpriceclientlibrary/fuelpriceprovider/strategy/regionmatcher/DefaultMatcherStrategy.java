package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher;

import android.location.Address;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.base.Strings;

import static com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher.UnitedStates.Map;


public class DefaultMatcherStrategy implements MatcherStrategy {

  // TODO implement matchRegion algorithm
  /**
   * Synchronous implementation of matchRegion
   * pseudo-code
   * get address's city
   * get address's state
   *
   * match the address's city to the city list
   * if the address's city is in the city list, look no further
   * (have specific dataset)
   *
   * else
   * match the address's state to the state list
   * if the address's state is in the state list, look no further
   * (have specific dataset)
   *
   * else
   * match the address's state in the PADD region list
   * if the address's state is in the PADD list, look no further
   * else return no match
   *
   * @param address address
   * @return coded region name prefix
   */
  @NonNull
  @Override
  public String matchRegion(@NonNull Address address) {

    // Address data that is used to be match with a region name
    @Nullable
    String locality = address.getLocality();

    // Check if locality is set
    if (!Strings.isNullOrEmpty(locality)){
      // cleanup the locality string
      locality = locality.replace(" ","").toLowerCase().trim();

      // MATCH LOCALITY (CITIES)
      // Look up for specific cities (locality), if a match is found, look no further!
      // return the city's name as the region name
      if (DataRegionMap.Cities.Map.containsKey(locality)){
        // This particular city region has its own data set, use the matched.
        return DataRegionMap.Cities.Map.get(locality);
      }
    }

    @Nullable
    String adminArea = address.getAdminArea();

    // CHECK ADMIN AREA (STATES)
    if (!Strings.isNullOrEmpty(adminArea)) {
      // cleanup the adminArea string
      adminArea = adminArea.replace(" ","").toLowerCase().trim();

      // check if the adminArea is an abbreviation
      if (!adminArea.matches("[a-zA-Z]{0,2}")) {
        // adminArea is not abbreviation, check if it matches full state names
        if (UnitedStates.Map.containsKey(adminArea)) {
          // adminArea get the corresponding the abbreviation
          adminArea = Map.get(adminArea);
        }
      }
    }else{
      // can't find a match in the UnitedStates
      return DataRegionMap.DEFAULT;
    }

    // MATCH ADMIN AREA (STATES)
    // Check if the state has its own data set
    if (DataRegionMap.States.Map.containsKey(adminArea)){
      // adminArea refers to a state that has its own data set
      return DataRegionMap.States.Map.get(adminArea);
    }else{
      // State doesn't have its own data set, match state with a PADD region
      if (DataRegionMap.PADD.Map.containsKey(adminArea)){
        // adminArea matched with a PADD region.
        return DataRegionMap.PADD.Map.get(adminArea);
      }else{
        // adminArea doesn't match any mapped PADD regions
        return DataRegionMap.DEFAULT;
      }
    }
  }

  /**
   * Multi-thread implementation of matchRegion
   * pseudo-code
   * get address's city
   * get address's state
   *
   * thread 1
   * match the address's city to the city list
   * if the address's city is in the city list, look no further
   *
   * thread 2
   * match the address's state to the state list
   * if the address's state is in the state list, look no further
   * (have specific dataset)
   *
   * thread 3
   * match the address's state in the PADD region list
   * the address's state must match a PADD region
   *
   * Note: city and state lookup can run in parallel,
   *
   * thread 1
   * ... wait for city result
   * if city has result, return it
   * else
   *
   * thread 2
   * ... state mapping process
   * if state has result, return it only if city is empty, (depends on city result)
   * else wait for padd result
   *
   * thread 3
   * ...wait for padd result
   * if padd has result, return it only if state is empty. (depends on state result)
   * else return empty (no match)
   *
   *
   * thread 2 only returns when thread 1 returns empty
   * thread 3 only returns when thread 2 returns empty,
   *
   * thread 1 blocks thread 2 from returning mapping result, but not its mapping process
   * thread 2 blocks thread 3 from returning mapping result, but not its mapping process
   *
   * @param address address
   * @return coded region name prefix
   */
  private String multithread(@NonNull Address address){
    return "";
  }
}
