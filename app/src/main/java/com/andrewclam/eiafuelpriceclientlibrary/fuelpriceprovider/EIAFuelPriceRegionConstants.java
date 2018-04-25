package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider;

import java.util.HashMap;

/**
 * TODO put the constants in database for retrieval
 */
public final class EIAFuelPriceRegionConstants {
  /**
   * EIAFuelPriceRegionConstants
   */
  // City Specific Name
  static final String NAME_CITY_BOSTON = "Boston";
  static final String NAME_CITY_CHICAGO = "Chicago";
  static final String NAME_CITY_CLEVELAND = "Cleveland";
  static final String NAME_CITY_DENVER = "Denver";
  static final String NAME_CITY_HOUSTON = "Houston";
  static final String NAME_CITY_LOS_ANGELES = "Los Angeles";
  static final String NAME_CITY_MIAMI = "Miami";
  static final String NAME_CITY_NEW_YORK_CITY = "New York City";
  static final String NAME_CITY_SAN_FRANCISCO = "San Francisco";
  static final String NAME_CITY_SEATTLE = "Seattle";

  // State Specific Names
  static final String NAME_STATE_CA = "California";
  static final String NAME_STATE_CO = "Colorado";
  static final String NAME_STATE_FL = "Florida";
  static final String NAME_STATE_MA = "Massachusetts";
  static final String NAME_STATE_MI = "Minnesota";
  static final String NAME_STATE_NY = "New York";
  static final String NAME_STATE_OH = "Ohio";
  static final String NAME_STATE_TX = "Texas";
  static final String NAME_STATE_WA = "Washington";

  // Region Name
  static final String NAME_PADD1 = "East Coast";
  static final String NAME_PADD1A = "New England";
  static final String NAME_PADD1B = "Central Atlantic";
  static final String NAME_PADD1C = "Lower Atlantic";
  static final String NAME_PADD2 = "Midwest";
  static final String NAME_PADD3 = "Gulf Coast";
  static final String NAME_PADD4 = "Rocky Mountain";
  static final String NAME_PADD5 = "West Coast (PADD 5) Except California";

  // STATE_MAP_KEY_SHORT can query the abbreviation as values, and then return complete state name
  static final HashMap<String, String> STATE_MAP_KEY_SHORT;
  static {
    STATE_MAP_KEY_SHORT = new HashMap<>();
    STATE_MAP_KEY_SHORT.put("AL", "Alabama");
    STATE_MAP_KEY_SHORT.put("AK", "Alaska");
    STATE_MAP_KEY_SHORT.put("AB", "Alberta");
    STATE_MAP_KEY_SHORT.put("AZ", "Arizona");
    STATE_MAP_KEY_SHORT.put("AR", "Arkansas");
    STATE_MAP_KEY_SHORT.put("BC", "British Columbia");
    STATE_MAP_KEY_SHORT.put("CA", "California");
    STATE_MAP_KEY_SHORT.put("CO", "Colorado");
    STATE_MAP_KEY_SHORT.put("CT", "Connecticut");
    STATE_MAP_KEY_SHORT.put("DE", "Delaware");
    STATE_MAP_KEY_SHORT.put("DC", "District Of Columbia");
    STATE_MAP_KEY_SHORT.put("FL", "Florida");
    STATE_MAP_KEY_SHORT.put("GA", "Georgia");
    STATE_MAP_KEY_SHORT.put("GU", "Guam");
    STATE_MAP_KEY_SHORT.put("HI", "Hawaii");
    STATE_MAP_KEY_SHORT.put("ID", "Idaho");
    STATE_MAP_KEY_SHORT.put("IL", "Illinois");
    STATE_MAP_KEY_SHORT.put("IN", "Indiana");
    STATE_MAP_KEY_SHORT.put("IA", "Iowa");
    STATE_MAP_KEY_SHORT.put("KS", "Kansas");
    STATE_MAP_KEY_SHORT.put("KY", "Kentucky");
    STATE_MAP_KEY_SHORT.put("LA", "Louisiana");
    STATE_MAP_KEY_SHORT.put("ME", "Maine");
    STATE_MAP_KEY_SHORT.put("MB", "Manitoba");
    STATE_MAP_KEY_SHORT.put("MD", "Maryland");
    STATE_MAP_KEY_SHORT.put("MA", "Massachusetts");
    STATE_MAP_KEY_SHORT.put("MI", "Michigan");
    STATE_MAP_KEY_SHORT.put("MN", "Minnesota");
    STATE_MAP_KEY_SHORT.put("MS", "Mississippi");
    STATE_MAP_KEY_SHORT.put("MO", "Missouri");
    STATE_MAP_KEY_SHORT.put("MT", "Montana");
    STATE_MAP_KEY_SHORT.put("NE", "Nebraska");
    STATE_MAP_KEY_SHORT.put("NV", "Nevada");
    STATE_MAP_KEY_SHORT.put("NB", "New Brunswick");
    STATE_MAP_KEY_SHORT.put("NH", "New Hampshire");
    STATE_MAP_KEY_SHORT.put("NJ", "New Jersey");
    STATE_MAP_KEY_SHORT.put("NM", "New Mexico");
    STATE_MAP_KEY_SHORT.put("NY", "New York");
    STATE_MAP_KEY_SHORT.put("NF", "Newfoundland");
    STATE_MAP_KEY_SHORT.put("NC", "North Carolina");
    STATE_MAP_KEY_SHORT.put("ND", "North Dakota");
    STATE_MAP_KEY_SHORT.put("NT", "Northwest Territories");
    STATE_MAP_KEY_SHORT.put("NS", "Nova Scotia");
    STATE_MAP_KEY_SHORT.put("NU", "Nunavut");
    STATE_MAP_KEY_SHORT.put("OH", "Ohio");
    STATE_MAP_KEY_SHORT.put("OK", "Oklahoma");
    STATE_MAP_KEY_SHORT.put("ON", "Ontario");
    STATE_MAP_KEY_SHORT.put("OR", "Oregon");
    STATE_MAP_KEY_SHORT.put("PA", "Pennsylvania");
    STATE_MAP_KEY_SHORT.put("PE", "Prince Edward Island");
    STATE_MAP_KEY_SHORT.put("PR", "Puerto Rico");
    STATE_MAP_KEY_SHORT.put("QC", "Quebec");
    STATE_MAP_KEY_SHORT.put("RI", "Rhode Island");
    STATE_MAP_KEY_SHORT.put("SK", "Saskatchewan");
    STATE_MAP_KEY_SHORT.put("SC", "South Carolina");
    STATE_MAP_KEY_SHORT.put("SD", "South Dakota");
    STATE_MAP_KEY_SHORT.put("TN", "Tennessee");
    STATE_MAP_KEY_SHORT.put("TX", "Texas");
    STATE_MAP_KEY_SHORT.put("UT", "Utah");
    STATE_MAP_KEY_SHORT.put("VT", "Vermont");
    STATE_MAP_KEY_SHORT.put("VI", "Virgin Islands");
    STATE_MAP_KEY_SHORT.put("VA", "Virginia");
    STATE_MAP_KEY_SHORT.put("WA", "Washington");
    STATE_MAP_KEY_SHORT.put("WV", "West Virginia");
    STATE_MAP_KEY_SHORT.put("WI", "Wisconsin");
    STATE_MAP_KEY_SHORT.put("WY", "Wyoming");
    STATE_MAP_KEY_SHORT.put("YT", "Yukon Territory");
  }

  // STATE_MAP_KEY_FULL can query the complete state name, and then return the abbreviation as values
  static final HashMap<String, String> STATE_MAP_KEY_FULL;
  static {
    STATE_MAP_KEY_FULL = new HashMap<>();
    STATE_MAP_KEY_FULL.put("Alabama", "AL");
    STATE_MAP_KEY_FULL.put("Alaska", "AK");
    STATE_MAP_KEY_FULL.put("Alberta", "AB");
    STATE_MAP_KEY_FULL.put("American Samoa", "AS");
    STATE_MAP_KEY_FULL.put("Arizona", "AZ");
    STATE_MAP_KEY_FULL.put("Arkansas", "AR");
    STATE_MAP_KEY_FULL.put("Armed Forces (AE)", "AE");
    STATE_MAP_KEY_FULL.put("Armed Forces Americas", "AA");
    STATE_MAP_KEY_FULL.put("Armed Forces Pacific", "AP");
    STATE_MAP_KEY_FULL.put("British Columbia", "BC");
    STATE_MAP_KEY_FULL.put("California", "CA");
    STATE_MAP_KEY_FULL.put("Colorado", "CO");
    STATE_MAP_KEY_FULL.put("Connecticut", "CT");
    STATE_MAP_KEY_FULL.put("Delaware", "DE");
    STATE_MAP_KEY_FULL.put("District Of Columbia", "DC");
    STATE_MAP_KEY_FULL.put("Florida", "FL");
    STATE_MAP_KEY_FULL.put("Georgia", "GA");
    STATE_MAP_KEY_FULL.put("Guam", "GU");
    STATE_MAP_KEY_FULL.put("Hawaii", "HI");
    STATE_MAP_KEY_FULL.put("Idaho", "ID");
    STATE_MAP_KEY_FULL.put("Illinois", "IL");
    STATE_MAP_KEY_FULL.put("Indiana", "IN");
    STATE_MAP_KEY_FULL.put("Iowa", "IA");
    STATE_MAP_KEY_FULL.put("Kansas", "KS");
    STATE_MAP_KEY_FULL.put("Kentucky", "KY");
    STATE_MAP_KEY_FULL.put("Louisiana", "LA");
    STATE_MAP_KEY_FULL.put("Maine", "ME");
    STATE_MAP_KEY_FULL.put("Manitoba", "MB");
    STATE_MAP_KEY_FULL.put("Maryland", "MD");
    STATE_MAP_KEY_FULL.put("Massachusetts", "MA");
    STATE_MAP_KEY_FULL.put("Michigan", "MI");
    STATE_MAP_KEY_FULL.put("Minnesota", "MN");
    STATE_MAP_KEY_FULL.put("Mississippi", "MS");
    STATE_MAP_KEY_FULL.put("Missouri", "MO");
    STATE_MAP_KEY_FULL.put("Montana", "MT");
    STATE_MAP_KEY_FULL.put("Nebraska", "NE");
    STATE_MAP_KEY_FULL.put("Nevada", "NV");
    STATE_MAP_KEY_FULL.put("New Brunswick", "NB");
    STATE_MAP_KEY_FULL.put("New Hampshire", "NH");
    STATE_MAP_KEY_FULL.put("New Jersey", "NJ");
    STATE_MAP_KEY_FULL.put("New Mexico", "NM");
    STATE_MAP_KEY_FULL.put("New York", "NY");
    STATE_MAP_KEY_FULL.put("Newfoundland", "NF");
    STATE_MAP_KEY_FULL.put("North Carolina", "NC");
    STATE_MAP_KEY_FULL.put("North Dakota", "ND");
    STATE_MAP_KEY_FULL.put("Northwest Territories", "NT");
    STATE_MAP_KEY_FULL.put("Nova Scotia", "NS");
    STATE_MAP_KEY_FULL.put("Nunavut", "NU");
    STATE_MAP_KEY_FULL.put("Ohio", "OH");
    STATE_MAP_KEY_FULL.put("Oklahoma", "OK");
    STATE_MAP_KEY_FULL.put("Ontario", "ON");
    STATE_MAP_KEY_FULL.put("Oregon", "OR");
    STATE_MAP_KEY_FULL.put("Pennsylvania", "PA");
    STATE_MAP_KEY_FULL.put("Prince Edward Island", "PE");
    STATE_MAP_KEY_FULL.put("Puerto Rico", "PR");
    STATE_MAP_KEY_FULL.put("Quebec", "QC");
    STATE_MAP_KEY_FULL.put("Rhode Island", "RI");
    STATE_MAP_KEY_FULL.put("Saskatchewan", "SK");
    STATE_MAP_KEY_FULL.put("South Carolina", "SC");
    STATE_MAP_KEY_FULL.put("South Dakota", "SD");
    STATE_MAP_KEY_FULL.put("Tennessee", "TN");
    STATE_MAP_KEY_FULL.put("Texas", "TX");
    STATE_MAP_KEY_FULL.put("Utah", "UT");
    STATE_MAP_KEY_FULL.put("Vermont", "VT");
    STATE_MAP_KEY_FULL.put("Virgin Islands", "VI");
    STATE_MAP_KEY_FULL.put("Virginia", "VA");
    STATE_MAP_KEY_FULL.put("Washington", "WA");
    STATE_MAP_KEY_FULL.put("West Virginia", "WV");
    STATE_MAP_KEY_FULL.put("Wisconsin", "WI");
    STATE_MAP_KEY_FULL.put("Wyoming", "WY");
    STATE_MAP_KEY_FULL.put("Yukon Territory", "YT");
  }

  /**
   * Map of PADD cities that EIA has a dedicated data set, more specific than its states data set
   */
  static final HashMap<String, String> PADD_CITY_MAP;
  static {
    PADD_CITY_MAP = new HashMap<>();
    PADD_CITY_MAP.put("boston", NAME_CITY_BOSTON);
    PADD_CITY_MAP.put("chicago", NAME_CITY_CHICAGO);
    PADD_CITY_MAP.put("cleveland", NAME_CITY_CLEVELAND);
    PADD_CITY_MAP.put("denver", NAME_CITY_DENVER);
    PADD_CITY_MAP.put("houston", NAME_CITY_HOUSTON);
    PADD_CITY_MAP.put("los angeles", NAME_CITY_LOS_ANGELES);
    PADD_CITY_MAP.put("miami", NAME_CITY_MIAMI);
    PADD_CITY_MAP.put("new york city", NAME_CITY_NEW_YORK_CITY);
    PADD_CITY_MAP.put("san francisco", NAME_CITY_SAN_FRANCISCO);
    PADD_CITY_MAP.put("seattle", NAME_CITY_SEATTLE);
  }

  /**
   * Map of PADD states that EIA has a dedicated data set, more specific than its region data set.
   */
  static final HashMap<String, String> PADD_STATE_MAP;
  static {
    PADD_STATE_MAP = new HashMap<>();
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("CA"), NAME_STATE_CA);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("CO"), NAME_STATE_CO);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("FL"), NAME_STATE_FL);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("MA"), NAME_STATE_MA);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("MI"), NAME_STATE_MI);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("NY"), NAME_STATE_NY);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("OH"), NAME_STATE_OH);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("TX"), NAME_STATE_TX);
    PADD_STATE_MAP.put(STATE_MAP_KEY_SHORT.get("WA"), NAME_STATE_WA);
  }

  /**
   * Map of PADD regions that EIA has a data set, more specific than national data set
   */
  static final HashMap<String, String> PADD_REGION_MAP;
  static {
    PADD_REGION_MAP = new HashMap<>();
    // PADD1 EAST COAST STATES
    // "ME","NH","VT","MA","CT","RI","NY","NJ","DE","PA","MD","WV","VA","NC","SC","GA","FL"

    // PADD1A NEW ENGLAND STATES
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("ME"), NAME_PADD1A);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NH"), NAME_PADD1A);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("VT"), NAME_PADD1A);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MA"), NAME_PADD1A);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("CT"), NAME_PADD1A);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("RI"), NAME_PADD1A);

    // PADD1B CENTRAL ATLANTIC STATES
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NY"), NAME_PADD1B);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NJ"), NAME_PADD1B);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("DE"), NAME_PADD1B);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("PA"), NAME_PADD1B);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MD"), NAME_PADD1B);

    // PADD1C LOWER ATLANTIC STATES
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("WV"), NAME_PADD1C);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("VA"), NAME_PADD1C);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NC"), NAME_PADD1C);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("SC"), NAME_PADD1C);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("GA"), NAME_PADD1C);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("FL"), NAME_PADD1C);

    // PADD2 MIDE WEST STATES
    // "OH","KY","TN","IN","MI","IL","WI","MN","IA","MO","ND","SD","NE","KS","OK"
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("OH"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("KY"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("TN"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("IN"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MI"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("IL"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("WI"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("WN"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("IA"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MO"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("ND"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("SD"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NE"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("KS"), NAME_PADD2);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("OK"), NAME_PADD2);

    // PADD3_GULF_COAST STATES
    // "NM","TX","AR","MS","AL","LA"
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NM"), NAME_PADD3);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("TX"), NAME_PADD3);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("AR"), NAME_PADD3);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MS"), NAME_PADD3);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("AL"), NAME_PADD3);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("LA"), NAME_PADD3);

    // PADD4_ROCKY_MOUNTAIN
    // "CO","WY","UT","ID","MT"
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("CO"), NAME_PADD4);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("WY"), NAME_PADD4);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("UT"), NAME_PADD4);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("ID"), NAME_PADD4);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("MT"), NAME_PADD4);

    // PADD5_WEST_COAST
    // "WA","OR","NV","AZ","CA","AK","HI"
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("WA"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("OR"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("NV"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("AZ"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("CA"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("AK"), NAME_PADD5);
    PADD_REGION_MAP.put(STATE_MAP_KEY_SHORT.get("HI"), NAME_PADD5);
  }
}
