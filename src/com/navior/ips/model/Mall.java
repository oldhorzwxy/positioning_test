/**
 * ==============================BEGIN_COPYRIGHT===============================
 * ===================NAVIOR CO.,LTD. PROPRIETARY INFORMATION==================
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with NAVIOR CO.,LTD. and may not be copied or
 * disclosed except in accordance with the terms of that agreement.
 * ==========Copyright (c) 2003 NAVIOR CO.,LTD. All Rights Reserved.===========
 * ===============================END_COPYRIGHT================================
 *
 * @author Administrator
 * @date Jun 12, 2013
 */

package com.navior.ips.model;

import java.io.Serializable;
import java.util.List;

public class Mall implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -1849384330795171645L;
  private int id;
  private int cityId;
  private double lat;
  private double lng;
  private String logo;
  private int type;
  private String nm;
  private int w;
  private int h;
  private String addr;
  private int focus_count;
  private List<Floor> l;
  private List<Path> ps;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
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

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getNm() {
    return nm;
  }

  public void setNm(String nm) {
    this.nm = nm;
  }

  public int getW() {
    return w;
  }

  public void setW(int w) {
    this.w = w;
  }

  public int getH() {
    return h;
  }

  public void setH(int h) {
    this.h = h;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public int getFocus_count() {
    return focus_count;
  }

  public void setFocus_count(int focus_count) {
    this.focus_count = focus_count;
  }

  public List<Floor> getL() {
    return l;
  }

  public void setL(List<Floor> l) {
    this.l = l;
  }

  public String toString() {
    return nm;
  }

  public List<Path> getPs() {
    return ps;
  }

  public void setPs(List<Path> ps) {
    this.ps = ps;
  }

}
