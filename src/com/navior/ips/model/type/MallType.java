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
 * @date 2011-12-8
 */

package com.navior.ips.model.type;

public enum MallType implements NameValuePair {
  MALL(1, "商场"), airport(2, "机场"), station(4, "火车站"), hospital(8, "医院"), museum(
      16, "博物馆"), furniture(32, "家居"), university(64, "大学"), library(128, "图书馆"), AIRPORT(
      256, "机场"), STATION(512, "火车站");

  private final int value;
  private final String name;

  public String toString() {
    return name;
  }

  MallType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static MallType get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }
}
