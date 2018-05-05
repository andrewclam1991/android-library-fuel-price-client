package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping of constants as defined in the EIA Api
 * TODO perf isn't really an issue, maybe more robust to use SQL query instead of in-memory maps.
 */
public final class DataRegionMap {

  /**
   * Default region name prefix, use this when there is no matches
   */
  static final String DEFAULT = "U.S ";

  /**
   * List of Cities that have their own data set
   * each constant stores the EXACT data set region prefix in api,
   * DON'T MODIFY VALUES unless api changes
   * TODO Handle edge case where there are cities with the mapped name but it is not in the expected state
   * ex. Miami, OH where the expects Miami to be in FL
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
    public static final Map<String,String> Map;
    static{
      Map = new HashMap<>();
      Map.put("boston",BOSTON);
      Map.put("chicago",CHICAGO);
      Map.put("cleveland",CLEVELAND);
      Map.put("denver",DENVER);
      Map.put("houston",HOUSTON);
      Map.put("losangeles",LOS_ANGELES);
      Map.put("miami",MIAMI);
      Map.put("newyorkcity",NEW_YORK_CITY);
      Map.put("sanfrancisco",SAN_FRANCISCO);
      Map.put("seattle",SEATTLE);
    }
  }

  /**
   * List of states that have their own data set
   * Note: each constant stores the EXACT data set region prefix in api,
   * DON'T MODIFY VALUES unless api changes
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
    public static final Map<String,String> Map;
    static {
      Map = new HashMap<>();
      Map.put("ca",CA);
      Map.put("co",CO);
      Map.put("fl",FL);
      Map.put("ma",MA);
      Map.put("mi",MI);
      Map.put("ny",NY);
      Map.put("oh",OH);
      Map.put("tx",TX);
      Map.put("wa",WA);
    }
  }

  /**
   * List of PADD Regions that have their own data set
   * Note: each constant stores the EXACT data set region prefix in api,
   * DON'T MODIFY VALUES unless api changes
   */
  public static class PADD {
    private static final String PADD1 = "East Coast";
    private static final String PADD1A = "New England";
    private static final String PADD1B = "Central Atlantic";
    private static final String PADD1C = "Lower Atlantic";
    private static final String PADD2 = "Midwest";
    private static final String PADD3 = "Gulf Coast";
    private static final String PADD4 = "Rocky Mountain";
    private static final String PADD5 = "West Coast (PADD 5) Except California";


    public static final Map<String, String> Map;
    static {
      Map = new HashMap<>();

      // PADD1 EAST COAST STATES
      // "ME","NH","VT","MA","CT","RI","NY","NJ","DE","PA","MD","WV","VA","NC","SC","GA","FL"
      // PADD1A NEW ENGLAND STATES
      Map.put("me", PADD1A);
      Map.put("mh", PADD1A);
      Map.put("vt", PADD1A);
      Map.put("ma", PADD1A);
      Map.put("ct", PADD1A);
      Map.put("ri", PADD1A);

      // PADD1B CENTRAL ATLANTIC STATES
      Map.put("ny", PADD1B);
      Map.put("nj", PADD1B);
      Map.put("de", PADD1B);
      Map.put("pa", PADD1B);
      Map.put("md", PADD1B);

      // PADD1C LOWER ATLANTIC STATES
      Map.put("wv", PADD1C);
      Map.put("va", PADD1C);
      Map.put("nc", PADD1C);
      Map.put("sc", PADD1C);
      Map.put("ga", PADD1C);
      Map.put("fl", PADD1C);

      // PADD2 MIDE WEST STATES
      // "OH","KY","TN","IN","MI","IL","WI","MN","IA","MO","ND","SD","NE","KS","OK"
      Map.put("oh", PADD2);
      Map.put("ky", PADD2);
      Map.put("tn", PADD2);
      Map.put("in", PADD2);
      Map.put("mi", PADD2);
      Map.put("il", PADD2);
      Map.put("wi", PADD2);
      Map.put("wn", PADD2);
      Map.put("ia", PADD2);
      Map.put("mo", PADD2);
      Map.put("nd", PADD2);
      Map.put("sd", PADD2);
      Map.put("ne", PADD2);
      Map.put("ks", PADD2);
      Map.put("ok", PADD2);

      // PADD3_GULF_COAST STATES
      // "NM","TX","AR","MS","AL","LA"
      Map.put("nm", PADD3);
      Map.put("tx", PADD3);
      Map.put("ar", PADD3);
      Map.put("ms", PADD3);
      Map.put("al", PADD3);
      Map.put("la", PADD3);

      // PADD4_ROCKY_MOUNTAIN
      // "CO","WY","UT","ID","MT"
      Map.put("co", PADD4);
      Map.put("wy", PADD4);
      Map.put("ut", PADD4);
      Map.put("id", PADD4);
      Map.put("mt", PADD4);

      // PADD5_WEST_COAST
      // "WA","OR","NV","AZ","CA","AK","HI"
      Map.put("wa", PADD5);
      Map.put("or", PADD5);
      Map.put("nv", PADD5);
      Map.put("az", PADD5);
      Map.put("ca", PADD5);
      Map.put("ak", PADD5);
      Map.put("hi", PADD5);
    }
  }

}
