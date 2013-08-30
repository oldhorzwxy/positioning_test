/**
 * ==============================BEGIN_COPYRIGHT===============================
 * ===================NAVIOR CO.,LTD. PROPRIETARY INFORMATION==================
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with NAVIOR CO.,LTD. and may not be copied or
 * disclosed except in accordance with the terms of that agreement.
 * ==========Copyright (c) 2003 NAVIOR CO.,LTD. All Rights Reserved.===========
 * ===============================END_COPYRIGHT================================
 *
 * @author wangxiayang
 * @date 26/08/13
 */
package com.navior.test.positioning;

public class RssiRecord {
  private int rssi;
  private String starName;

  RssiRecord(String starName, int rssi) {
    setRssi(rssi);
    setStarName(starName);
  }

  int getRssi() {
    return rssi;
  }

  void setRssi(int rssi) {
    this.rssi = rssi;
  }

  String getStarName() {
    return starName;
  }

  void setStarName(String starName) {
    this.starName = starName;
  }
}
