package com.navior.ips.model;

import java.io.Serializable;
import java.util.List;

public class City implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 3751808607485837695L;

  private int id;
  private String name;
  private String abbr;
  private String code;
  private double lat;
  private double lng;
  private double mapsize;
  private List<Mall> malls;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbr() {
    return abbr;
  }

  public void setAbbr(String abbr) {
    this.abbr = abbr;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLng() {
    return lng;
  }

  public void setLng(double lng) {
    this.lng = lng;
  }

  public double getMapsize() {
    return mapsize;
  }

  public void setMapsize(double mapsize) {
    this.mapsize = mapsize;
  }

  public List<Mall> getMalls() {
    return malls;
  }

  public void setMalls(List<Mall> malls) {
    this.malls = malls;
  }

  public String toString() {
    return name;
  }

}
