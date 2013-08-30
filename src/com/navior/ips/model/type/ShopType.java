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
 * @date Jul 3, 2013
 */

package com.navior.ips.model.type;

public enum ShopType implements NameValuePair {
  BG(0x1, "BG"), STR(0x2, "STR"), DSBLD(0x4, "DSBLD"), PICON(0x8, "PICON"), EMPTY(
      0x10, "EMPTY"), PLA(0x20, "PLA"), SQUE(0x40, "SQUE"), TXT(0x80, "TXT"), PLP(
      0x100, "PLP"), LG(0x200, "LG"), ENT(0x400, "ENT"), CII(0x800, "CII"), GATE(
      0x1000, "GATE"), CHEIN(0x2000, "CHEIN"), CPOINT(0x4000, "CPOINT"), DLINE(
      0x8000, "DLINE");

  private final int value;
  private final String name;

  public String toString() {
    return name;
  }

  ShopType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static ShopType get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }
}
