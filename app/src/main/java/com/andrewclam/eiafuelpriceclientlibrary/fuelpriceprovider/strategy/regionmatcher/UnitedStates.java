package com.andrewclam.eiafuelpriceclientlibrary.fuelpriceprovider.strategy.regionmatcher;

import java.util.HashMap;

/**
 * Constant class to store the mapping of all U.S.A States and Territories
 */
final class UnitedStates {
  // Map can query the complete state name,
  // and then return the abbreviation as values
  static final HashMap<String, String> Map;
  static {
    Map = new HashMap<>();
    Map.put("alabama", "al");
    Map.put("alaska", "ak");
    Map.put("arizona", "az");
    Map.put("arkansas", "ar");
    Map.put("california", "ca");
    Map.put("colorado", "co");
    Map.put("connecticut", "ct");
    Map.put("delaware", "de");
    Map.put("districtofcolumbia", "dc");
    Map.put("florida", "fl");
    Map.put("georgia", "ga");
    Map.put("guam", "gu");
    Map.put("hawaii", "hi");
    Map.put("idaho", "id");
    Map.put("illinois", "il");
    Map.put("indiana", "in");
    Map.put("iowa", "ia");
    Map.put("kansas", "ks");
    Map.put("kentucky", "ky");
    Map.put("louisiana", "la");
    Map.put("maine", "me");
    Map.put("maryland", "md");
    Map.put("massachusetts", "ma");
    Map.put("michigan", "mi");
    Map.put("minnesota", "mn");
    Map.put("mississippi", "ms");
    Map.put("missouri", "mo");
    Map.put("montana", "mt");
    Map.put("nebraska", "ne");
    Map.put("nevada", "nv");
    Map.put("newhampshire", "nh");
    Map.put("newjersey", "nj");
    Map.put("newmexico", "nm");
    Map.put("newyork", "ny");
    Map.put("northcarolina", "nc");
    Map.put("northdakota", "nd");
    Map.put("ohio", "oh");
    Map.put("oklahoma", "ok");
    Map.put("oregon", "or");
    Map.put("pennsylvania", "pa");
    Map.put("puertorico", "pr");
    Map.put("rhodeisland", "ri");
    Map.put("southcarolina", "sc");
    Map.put("southdakota", "sd");
    Map.put("tennessee", "tn");
    Map.put("texas", "tx");
    Map.put("utah", "ut");
    Map.put("vermont", "vt");
    Map.put("virginia", "va");
    Map.put("washington", "wa");
    Map.put("west Virginia", "wv");
    Map.put("wisconsin", "wi");
    Map.put("wyoming", "wy");
  }
}
