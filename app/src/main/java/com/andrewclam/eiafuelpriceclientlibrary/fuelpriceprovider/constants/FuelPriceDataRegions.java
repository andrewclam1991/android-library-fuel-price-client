package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.constants;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.constants.USStates.STATE_MAP_KEY_SHORT;

/**
 * TODO put the constants in database for retrieval
 */
public final class FuelPriceDataRegions {

  /**
   * List of Cities that have their own data set
   * each constant stores the EXACT data set region prefix, DON'T MODIFY
   */
  public static class Cities {
    private static final String BOSTON = "Boston";
    private static final String CHICAGO = "Chicago";
    private static final String CLEVELAND = "Cleveland";
    private static final String DENVER = "Denver";
    private static final String HOUSTON = "Houston";
    private static final String LOS_ANGELES = "Los Angeles";
    private static final String MIAMI = "Miami";
    private static final String NEW_YORK_CITY = "New York City";
    private static final String SAN_FRANCISCO = "San Francisco";
    private static final String SEATTLE = "Seattle";

    // White list approach, if set contains the value, use the value as is
    public static final Set<String> Set;
    static{
      Set = new HashSet<>();
      Set.add(BOSTON);
      Set.add(CHICAGO);
      Set.add(CLEVELAND);
      Set.add(DENVER);
      Set.add(HOUSTON);
      Set.add(LOS_ANGELES);
      Set.add(MIAMI);
      Set.add(NEW_YORK_CITY);
      Set.add(SAN_FRANCISCO);
      Set.add(SEATTLE);
    }
  }

  /**
   * List of states that have their own data set
   * Note: each constant stores the EXACT data set region prefix, DON'T MODIFY
   */
  public static class States {
    private static final String CA = "California";
    private static final String CO = "Colorado";
    private static final String FL = "Florida";
    private static final String MA = "Massachusetts";
    private static final String MI = "Minnesota";
    private static final String NY = "New York";
    private static final String OH = "Ohio";
    private static final String TX = "Texas";
    private static final String WA = "Washington";

    // White list approach, if set contains the value, use the value as is
    public static final Set<String> Set;
    static {
      Set = new HashSet<>();
      Set.add(CA);
      Set.add(CO);
      Set.add(FL);
      Set.add(MA);
      Set.add(MI);
      Set.add(NY);
      Set.add(OH);
      Set.add(TX);
      Set.add(WA);
    }
  }

  // PADD Regions that have their own data Set
  public static class PADD {
    private static final String PADD1 = "East Coast";
    private static final String PADD1A = "New England";
    private static final String PADD1B = "Central Atlantic";
    private static final String PADD1C = "Lower Atlantic";
    private static final String PADD2 = "Midwest";
    private static final String PADD3 = "Gulf Coast";
    private static final String PADD4 = "Rocky Mountain";
    private static final String PADD5 = "West Coast (PADD 5) Except California";


    public static final HashMap<String, String> PADD_REGION_MAP;
    static {
      PADD_REGION_MAP = new HashMap<>();

      // PADD1 EAST COAST STATES
      // "ME","NH","VT","MA","CT","RI","NY","NJ","DE","PA","MD","WV","VA","NC","SC","GA","FL"
      // PADD1A NEW ENGLAND STATES
      PADD_REGION_MAP.put("ME", PADD1A);
      PADD_REGION_MAP.put("NH", PADD1A);
      PADD_REGION_MAP.put("VT", PADD1A);
      PADD_REGION_MAP.put("MA", PADD1A);
      PADD_REGION_MAP.put("CT", PADD1A);
      PADD_REGION_MAP.put("RI", PADD1A);

      // PADD1B CENTRAL ATLANTIC STATES
      PADD_REGION_MAP.put("NY", PADD1B);
      PADD_REGION_MAP.put("NJ", PADD1B);
      PADD_REGION_MAP.put("DE", PADD1B);
      PADD_REGION_MAP.put("PA", PADD1B);
      PADD_REGION_MAP.put("MD", PADD1B);

      // PADD1C LOWER ATLANTIC STATES
      PADD_REGION_MAP.put("WV", PADD1C);
      PADD_REGION_MAP.put("VA", PADD1C);
      PADD_REGION_MAP.put("NC", PADD1C);
      PADD_REGION_MAP.put("SC", PADD1C);
      PADD_REGION_MAP.put("GA", PADD1C);
      PADD_REGION_MAP.put("FL", PADD1C);

      // PADD2 MIDE WEST STATES
      // "OH","KY","TN","IN","MI","IL","WI","MN","IA","MO","ND","SD","NE","KS","OK"
      PADD_REGION_MAP.put("OH", PADD2);
      PADD_REGION_MAP.put("KY", PADD2);
      PADD_REGION_MAP.put("TN", PADD2);
      PADD_REGION_MAP.put("IN", PADD2);
      PADD_REGION_MAP.put("MI", PADD2);
      PADD_REGION_MAP.put("IL", PADD2);
      PADD_REGION_MAP.put("WI", PADD2);
      PADD_REGION_MAP.put("WN", PADD2);
      PADD_REGION_MAP.put("IA", PADD2);
      PADD_REGION_MAP.put("MO", PADD2);
      PADD_REGION_MAP.put("ND", PADD2);
      PADD_REGION_MAP.put("SD", PADD2);
      PADD_REGION_MAP.put("NE", PADD2);
      PADD_REGION_MAP.put("KS", PADD2);
      PADD_REGION_MAP.put("OK", PADD2);

      // PADD3_GULF_COAST STATES
      // "NM","TX","AR","MS","AL","LA"
      PADD_REGION_MAP.put("NM", PADD3);
      PADD_REGION_MAP.put("TX", PADD3);
      PADD_REGION_MAP.put("AR", PADD3);
      PADD_REGION_MAP.put("MS", PADD3);
      PADD_REGION_MAP.put("AL", PADD3);
      PADD_REGION_MAP.put("LA", PADD3);

      // PADD4_ROCKY_MOUNTAIN
      // "CO","WY","UT","ID","MT"
      PADD_REGION_MAP.put("CO", PADD4);
      PADD_REGION_MAP.put("WY", PADD4);
      PADD_REGION_MAP.put("UT", PADD4);
      PADD_REGION_MAP.put("ID", PADD4);
      PADD_REGION_MAP.put("MT", PADD4);

      // PADD5_WEST_COAST
      // "WA","OR","NV","AZ","CA","AK","HI"
      PADD_REGION_MAP.put("WA", PADD5);
      PADD_REGION_MAP.put("OR", PADD5);
      PADD_REGION_MAP.put("NV", PADD5);
      PADD_REGION_MAP.put("AZ", PADD5);
      PADD_REGION_MAP.put("CA", PADD5);
      PADD_REGION_MAP.put("AK", PADD5);
      PADD_REGION_MAP.put("HI", PADD5);
    }
  }

}
