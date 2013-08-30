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

public class Path implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1758585009737622007L;

  private int id;
  private int mallId;
  private int p1;
  private int p2;
  private int v;

  // set on client device not on server
  private POP point1;
  private POP point2;

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

  public int getP1() {
    return p1;
  }

  public void setP1(int p1) {
    this.p1 = p1;
  }

  public int getP2() {
    return p2;
  }

  public void setP2(int p2) {
    this.p2 = p2;
  }

  public int getV() {
    return v;
  }

  public void setV(int v) {
    this.v = v;
  }

  public POP getPoint1() {
    return point1;
  }

  public void setPoint1(POP point1) {
    this.point1 = point1;
  }

  public POP getPoint2() {
    return point2;
  }

  public void setPoint2(POP point2) {
    this.point2 = point2;
  }

}
