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
 * @date 2012-1-7
 */

package com.navior.ips.model.type;

public enum TableName implements NameValuePair {
  D_CITY(10, "d_city"), D_MALL(20, "d_mall"), D_FLOOR(30, "d_floor"), D_SHOP(
      40, "d_shop"), D_MALL_DETAIL(50, "d_malldetail"), D_SHOP_DETAIL(60,
      "d_shopdetail"), D_OPERATOR(70, "d_operator"), D_BINARY(80, "d_binary"), D_ENDUSER(
      90, "d_enduser");

  private final int value;
  private final String name;

  TableName(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static TableName getTableName(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }
}
