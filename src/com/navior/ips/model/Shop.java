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

import com.navior.ips.model.type.IcoType;
import com.navior.ips.model.type.ShopType;

import java.io.Serializable;

public class Shop implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1804811460404842349L;

  private int id;
  private int mallId;
  private int floorLevel;
  private int floorId;
  private String rno;
  private int t;
  private int cgid;
  private int ico;
  private String nm;
  private String logo;
  private double lt;
  private float[] lr;
  private byte[] op;
  private float[] shape;

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

  public int getFloorLevel() {
    return floorLevel;
  }

  public void setFloorLevel(int floorLevel) {
    this.floorLevel = floorLevel;
  }

  public int getFloorId() {
    return floorId;
  }

  public void setFloorId(int floorId) {
    this.floorId = floorId;
  }

  public String getRno() {
    return rno;
  }

  public void setRno(String rno) {
    this.rno = rno;
  }

  public int getT() {
    return t;
  }

  public void setT(int t) {
    this.t = t;
  }

  public int getCgid() {
    return cgid;
  }

  public void setCgid(int cgid) {
    this.cgid = cgid;
  }

  public int getIco() {
    return ico;
  }

  public void setIco(int ico) {
    this.ico = ico;
  }

  public double getLt() {
    return lt;
  }

  public void setLt(double lt) {
    this.lt = lt;
  }

  public float[] getLr() {
    return lr;
  }

  public void setLr(float[] lr) {
    this.lr = lr;
  }

  public String getNm() {
    return nm;
  }

  public void setNm(String nm) {
    this.nm = nm;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public byte[] getOp() {
    return op;
  }

  public void setOp(byte[] op) {
    this.op = op;
  }

  public float[] getShape() {
    return shape;
  }

  public void setShape(float[] shape) {
    this.shape = shape;
  }

  public String toString() {
    return "" + id + ". [" + ShopType.get(t) + "] "
        + (t == ShopType.PICON.getValue() ? IcoType.get(ico).getName() : nm);
  }

  public int opToShapeIndex(int opIndex) {
    int index = 0;
    if (op != null && opIndex < op.length) {
      for (int i = 0; i < opIndex; i++) {
        switch (op[i]) {
          case 0:
          case 1:
            index += 2;
            break;
          case 2:
            index += 6;
            break;
          default:
            break;
        }
      }
    }
    return index;
  }
}
