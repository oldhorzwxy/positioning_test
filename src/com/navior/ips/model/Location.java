/**
 * ==============================BEGIN_COPYRIGHT===============================
 * ===================NAVIOR CO.,LTD. PROPRIETARY INFORMATION==================
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with NAVIOR CO.,LTD. and may not be copied or
 * disclosed except in accordance with the terms of that agreement.
 * ==========Copyright (c) 2010 NAVIOR CO.,LTD. All Rights Reserved.===========
 * ===============================END_COPYRIGHT================================
 *
 * @author cs1
 * @date 13-8-5
 */
package com.navior.ips.model;

import java.io.Serializable;
import java.util.Date;

public class Location implements Serializable {

  private static final long serialVersionUID = -911379599675969609L;

  private int floorId;
  private float x;
  private float y;
  private double lat;
  private double lng;
  private String userId;
  private Date locTime;

  public int getFloorId() {
    return floorId;
  }

  public void setFloorId(int floorId) {
    this.floorId = floorId;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Date getLocTime() {
    return locTime;
  }

  public void setLocTime(Date locTime) {
    this.locTime = locTime;
  }
}
