package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.constants;

import java.util.HashMap;

/**
 * Constant class to store the map of all U.S State and territories
 * TODO use another small api to parse possible combination of state names?
 */
public final class USStates {

  public static final HashMap<String, String> STATE_MAP_KEY_SHORT;
  static {
    STATE_MAP_KEY_SHORT = new HashMap<>();
    STATE_MAP_KEY_SHORT.put("AL", "Alabama");
    STATE_MAP_KEY_SHORT.put("AK", "Alaska");
    STATE_MAP_KEY_SHORT.put("AZ", "Arizona");
    STATE_MAP_KEY_SHORT.put("AR", "Arkansas");
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
    STATE_MAP_KEY_SHORT.put("NH", "New Hampshire");
    STATE_MAP_KEY_SHORT.put("NJ", "New Jersey");
    STATE_MAP_KEY_SHORT.put("NM", "New Mexico");
    STATE_MAP_KEY_SHORT.put("NY", "New York");
    STATE_MAP_KEY_SHORT.put("NC", "North Carolina");
    STATE_MAP_KEY_SHORT.put("ND", "North Dakota");
    STATE_MAP_KEY_SHORT.put("OH", "Ohio");
    STATE_MAP_KEY_SHORT.put("OK", "Oklahoma");
    STATE_MAP_KEY_SHORT.put("ON", "Ontario");
    STATE_MAP_KEY_SHORT.put("OR", "Oregon");
    STATE_MAP_KEY_SHORT.put("PA", "Pennsylvania");
    STATE_MAP_KEY_SHORT.put("PR", "Puerto Rico");
    STATE_MAP_KEY_SHORT.put("RI", "Rhode Island");
    STATE_MAP_KEY_SHORT.put("SC", "South Carolina");
    STATE_MAP_KEY_SHORT.put("SD", "South Dakota");
    STATE_MAP_KEY_SHORT.put("TN", "Tennessee");
    STATE_MAP_KEY_SHORT.put("TX", "Texas");
    STATE_MAP_KEY_SHORT.put("UT", "Utah");
    STATE_MAP_KEY_SHORT.put("VT", "Vermont");
    STATE_MAP_KEY_SHORT.put("VA", "Virginia");
    STATE_MAP_KEY_SHORT.put("WA", "Washington");
    STATE_MAP_KEY_SHORT.put("WV", "West Virginia");
    STATE_MAP_KEY_SHORT.put("WI", "Wisconsin");
    STATE_MAP_KEY_SHORT.put("WY", "Wyoming");
  }

  // STATE_MAP_KEY_FULL can query the complete state name, and then return the abbreviation as values
  public static final HashMap<String, String> STATE_MAP_KEY_FULL;
  static {
    STATE_MAP_KEY_FULL = new HashMap<>();
    STATE_MAP_KEY_FULL.put("Alabama", "AL");
    STATE_MAP_KEY_FULL.put("Alaska", "AK");
    STATE_MAP_KEY_FULL.put("Arizona", "AZ");
    STATE_MAP_KEY_FULL.put("Arkansas", "AR");
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
    STATE_MAP_KEY_FULL.put("Maryland", "MD");
    STATE_MAP_KEY_FULL.put("Massachusetts", "MA");
    STATE_MAP_KEY_FULL.put("Michigan", "MI");
    STATE_MAP_KEY_FULL.put("Minnesota", "MN");
    STATE_MAP_KEY_FULL.put("Mississippi", "MS");
    STATE_MAP_KEY_FULL.put("Missouri", "MO");
    STATE_MAP_KEY_FULL.put("Montana", "MT");
    STATE_MAP_KEY_FULL.put("Nebraska", "NE");
    STATE_MAP_KEY_FULL.put("Nevada", "NV");
    STATE_MAP_KEY_FULL.put("New Hampshire", "NH");
    STATE_MAP_KEY_FULL.put("New Jersey", "NJ");
    STATE_MAP_KEY_FULL.put("New Mexico", "NM");
    STATE_MAP_KEY_FULL.put("New York", "NY");
    STATE_MAP_KEY_FULL.put("North Carolina", "NC");
    STATE_MAP_KEY_FULL.put("North Dakota", "ND");
    STATE_MAP_KEY_FULL.put("Ohio", "OH");
    STATE_MAP_KEY_FULL.put("Oklahoma", "OK");
    STATE_MAP_KEY_FULL.put("Ontario", "ON");
    STATE_MAP_KEY_FULL.put("Oregon", "OR");
    STATE_MAP_KEY_FULL.put("Pennsylvania", "PA");
    STATE_MAP_KEY_FULL.put("Puerto Rico", "PR");
    STATE_MAP_KEY_FULL.put("Rhode Island", "RI");
    STATE_MAP_KEY_FULL.put("South Carolina", "SC");
    STATE_MAP_KEY_FULL.put("South Dakota", "SD");
    STATE_MAP_KEY_FULL.put("Tennessee", "TN");
    STATE_MAP_KEY_FULL.put("Texas", "TX");
    STATE_MAP_KEY_FULL.put("Utah", "UT");
    STATE_MAP_KEY_FULL.put("Vermont", "VT");
    STATE_MAP_KEY_FULL.put("Virginia", "VA");
    STATE_MAP_KEY_FULL.put("Washington", "WA");
    STATE_MAP_KEY_FULL.put("West Virginia", "WV");
    STATE_MAP_KEY_FULL.put("Wisconsin", "WI");
    STATE_MAP_KEY_FULL.put("Wyoming", "WY");
  }
}
