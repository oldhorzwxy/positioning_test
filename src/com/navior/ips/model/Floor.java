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

public class Floor implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1005543950944179513L;
  private int id;
  private int mallId;
  private int level;
  private int w;
  private int h;
  private String brief;
  private String nm;
  private List<Shop> g;
  private List<POI> pois;
  private List<POP> pops;
  private List<POS> poss;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMallId() {
    return mallId;
  }

  public void setMallId(int mallId) {
    this.mallId = mallId;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
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

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getNm() {
    return nm;
  }

  public void setNm(String nm) {
    this.nm = nm;
  }

  public List<Shop> getG() {
    return g;
  }

  public void setG(List<Shop> g) {
    this.g = g;
  }

  public List<POI> getPois() {
    return pois;
  }

  public void setPois(List<POI> pois) {
    this.pois = pois;
  }

  public List<POP> getPops() {
    return pops;
  }

  public void setPops(List<POP> pops) {
    this.pops = pops;
  }

  public List<POS> getPoss() {
    return poss;
  }

  public void setPoss(List<POS> poss) {
    this.poss = poss;
  }

  public String toString() {
    return "[" + level + "] " + nm;
  }
}
