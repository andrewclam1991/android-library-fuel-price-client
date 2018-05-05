package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher;

import java.util.HashMap;

/**
 * Constant class to store the map of all U.S State and territories
 */
final class StateMap {
//  static final HashMap<String, String> STATE_MAP_KEY_ABBREVIATION;
//  static {
//    STATE_MAP_KEY_ABBREVIATION = new HashMap<>();
//    STATE_MAP_KEY_ABBREVIATION.put("AL", "alabama");
//    STATE_MAP_KEY_ABBREVIATION.put("AK", "alaska");
//    STATE_MAP_KEY_ABBREVIATION.put("AZ", "arizona");
//    STATE_MAP_KEY_ABBREVIATION.put("AR", "arkansas");
//    STATE_MAP_KEY_ABBREVIATION.put("CA", "california");
//    STATE_MAP_KEY_ABBREVIATION.put("CO", "colorado");
//    STATE_MAP_KEY_ABBREVIATION.put("CT", "connecticut");
//    STATE_MAP_KEY_ABBREVIATION.put("DE", "delaware");
//    STATE_MAP_KEY_ABBREVIATION.put("DC", "districtofcolumbia");
//    STATE_MAP_KEY_ABBREVIATION.put("FL", "florida");
//    STATE_MAP_KEY_ABBREVIATION.put("GA", "georgia");
//    STATE_MAP_KEY_ABBREVIATION.put("GU", "guam");
//    STATE_MAP_KEY_ABBREVIATION.put("HI", "hawaii");
//    STATE_MAP_KEY_ABBREVIATION.put("ID", "idaho");
//    STATE_MAP_KEY_ABBREVIATION.put("IL", "illinois");
//    STATE_MAP_KEY_ABBREVIATION.put("IN", "indiana");
//    STATE_MAP_KEY_ABBREVIATION.put("IA", "iowa");
//    STATE_MAP_KEY_ABBREVIATION.put("KS", "kansas");
//    STATE_MAP_KEY_ABBREVIATION.put("KY", "kentucky");
//    STATE_MAP_KEY_ABBREVIATION.put("LA", "louisiana");
//    STATE_MAP_KEY_ABBREVIATION.put("ME", "maine");
//    STATE_MAP_KEY_ABBREVIATION.put("MD", "maryland");
//    STATE_MAP_KEY_ABBREVIATION.put("MA", "massachusetts");
//    STATE_MAP_KEY_ABBREVIATION.put("MI", "michigan");
//    STATE_MAP_KEY_ABBREVIATION.put("MN", "minnesota");
//    STATE_MAP_KEY_ABBREVIATION.put("MS", "mississippi");
//    STATE_MAP_KEY_ABBREVIATION.put("MO", "missouri");
//    STATE_MAP_KEY_ABBREVIATION.put("MT", "montana");
//    STATE_MAP_KEY_ABBREVIATION.put("NE", "nebraska");
//    STATE_MAP_KEY_ABBREVIATION.put("NV", "nevada");
//    STATE_MAP_KEY_ABBREVIATION.put("NH", "newhampshire");
//    STATE_MAP_KEY_ABBREVIATION.put("NJ", "newjersey");
//    STATE_MAP_KEY_ABBREVIATION.put("NM", "newmexico");
//    STATE_MAP_KEY_ABBREVIATION.put("NY", "newyork");
//    STATE_MAP_KEY_ABBREVIATION.put("NC", "northcarolina");
//    STATE_MAP_KEY_ABBREVIATION.put("ND", "northdakota");
//    STATE_MAP_KEY_ABBREVIATION.put("OH", "ohio");
//    STATE_MAP_KEY_ABBREVIATION.put("OK", "oklahoma");
//    STATE_MAP_KEY_ABBREVIATION.put("ON", "ontario");
//    STATE_MAP_KEY_ABBREVIATION.put("OR", "oregon");
//    STATE_MAP_KEY_ABBREVIATION.put("PA", "pennsylvania");
//    STATE_MAP_KEY_ABBREVIATION.put("PR", "puertorico");
//    STATE_MAP_KEY_ABBREVIATION.put("RI", "rhodeisland");
//    STATE_MAP_KEY_ABBREVIATION.put("SC", "southcarolina");
//    STATE_MAP_KEY_ABBREVIATION.put("SD", "southdakota");
//    STATE_MAP_KEY_ABBREVIATION.put("TN", "tennessee");
//    STATE_MAP_KEY_ABBREVIATION.put("TX", "texas");
//    STATE_MAP_KEY_ABBREVIATION.put("UT", "utah");
//    STATE_MAP_KEY_ABBREVIATION.put("VT", "vermont");
//    STATE_MAP_KEY_ABBREVIATION.put("VA", "virginia");
//    STATE_MAP_KEY_ABBREVIATION.put("WA", "washington");
//    STATE_MAP_KEY_ABBREVIATION.put("WV", "westvirginia");
//    STATE_MAP_KEY_ABBREVIATION.put("WI", "wisconsin");
//    STATE_MAP_KEY_ABBREVIATION.put("WY", "wyoming");
//  }

  // FullMapToAbbr can query the complete state name,
  // and then return the abbreviation as values
  static final HashMap<String, String> FullMapToAbbr;

  static {
    FullMapToAbbr = new HashMap<>();
    FullMapToAbbr.put("alabama", "AL");
    FullMapToAbbr.put("alaska", "AK");
    FullMapToAbbr.put("arizona", "AZ");
    FullMapToAbbr.put("arkansas", "AR");
    FullMapToAbbr.put("california", "CA");
    FullMapToAbbr.put("colorado", "CO");
    FullMapToAbbr.put("connecticut", "CT");
    FullMapToAbbr.put("delaware", "DE");
    FullMapToAbbr.put("districtofcolumbia", "DC");
    FullMapToAbbr.put("florida", "FL");
    FullMapToAbbr.put("georgia", "GA");
    FullMapToAbbr.put("guam", "GU");
    FullMapToAbbr.put("hawaii", "HI");
    FullMapToAbbr.put("idaho", "ID");
    FullMapToAbbr.put("illinois", "IL");
    FullMapToAbbr.put("indiana", "IN");
    FullMapToAbbr.put("iowa", "IA");
    FullMapToAbbr.put("kansas", "KS");
    FullMapToAbbr.put("kentucky", "KY");
    FullMapToAbbr.put("louisiana", "LA");
    FullMapToAbbr.put("maine", "ME");
    FullMapToAbbr.put("maryland", "MD");
    FullMapToAbbr.put("massachusetts", "MA");
    FullMapToAbbr.put("michigan", "MI");
    FullMapToAbbr.put("minnesota", "MN");
    FullMapToAbbr.put("mississippi", "MS");
    FullMapToAbbr.put("missouri", "MO");
    FullMapToAbbr.put("montana", "MT");
    FullMapToAbbr.put("nebraska", "NE");
    FullMapToAbbr.put("nevada", "NV");
    FullMapToAbbr.put("newhampshire", "NH");
    FullMapToAbbr.put("newjersey", "NJ");
    FullMapToAbbr.put("newmexico", "NM");
    FullMapToAbbr.put("newyork", "NY");
    FullMapToAbbr.put("northcarolina", "NC");
    FullMapToAbbr.put("northdakota", "ND");
    FullMapToAbbr.put("ohio", "OH");
    FullMapToAbbr.put("oklahoma", "OK");
    FullMapToAbbr.put("ontario", "ON");
    FullMapToAbbr.put("oregon", "OR");
    FullMapToAbbr.put("pennsylvania", "PA");
    FullMapToAbbr.put("puertorico", "PR");
    FullMapToAbbr.put("rhodeisland", "RI");
    FullMapToAbbr.put("southcarolina", "SC");
    FullMapToAbbr.put("southdakota", "SD");
    FullMapToAbbr.put("tennessee", "TN");
    FullMapToAbbr.put("texas", "TX");
    FullMapToAbbr.put("utah", "UT");
    FullMapToAbbr.put("vermont", "VT");
    FullMapToAbbr.put("virginia", "VA");
    FullMapToAbbr.put("washington", "WA");
    FullMapToAbbr.put("west Virginia", "WV");
    FullMapToAbbr.put("wisconsin", "WI");
    FullMapToAbbr.put("wyoming", "WY");
  }
}
