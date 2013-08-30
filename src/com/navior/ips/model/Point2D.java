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
 * @date Jul 8, 2013
 */

package com.navior.ips.model;

import java.io.Serializable;

public class Point2D implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 8060568780629134602L;

  private int id;
  private int floorId;
  private float x;
  private float y;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

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

}
