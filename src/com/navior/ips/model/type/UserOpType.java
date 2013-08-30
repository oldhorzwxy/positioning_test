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

public enum UserOpType implements NameValuePair {
  APP_START(10, "App start"), APP_END(20, "App end");
  private final int value;
  private final String name;

  UserOpType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static UserOpType get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }

}
