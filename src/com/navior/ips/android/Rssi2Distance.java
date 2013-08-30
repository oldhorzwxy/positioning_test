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
 * @date 20/08/13
 */
package com.navior.ips.android;

/**
 * RSSI value to distance value transformer.
 * The formula is simple: [dist] doubles when [RSSI] increases by 5.
 */
public class Rssi2Distance {

  private final static int RSSI_BASE = -55;
  private final static int RSSI_INCREASE_STEP = -5;  // if RSSI_2 is 5 smaller than RSSI_1, then DISTANCE_2 is twice larger than DISTANCE_1

  /**
   * Calculate the rough distance from RSSI value.
   * In current version, it can only distinguish 1m to 8m.
   * @param rssi RSSI value, usually between -55 and -70
   * @return distance of float data type
   */
  static float getDistance( int rssi ) {
    return (float)Math.pow(2 + 0.0, (RSSI_BASE - rssi) / (-RSSI_INCREASE_STEP + 0.0));
  }
}
