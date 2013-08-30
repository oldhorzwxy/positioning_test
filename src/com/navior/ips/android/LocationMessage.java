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
 * @date 30/08/13
 */
package com.navior.ips.android;

public interface LocationMessage {
  int UNKNOWN_POS = 0;
  int NEW_LOCATION = 1;
  int FAIL_START_LOCATING = 2;
  int TO_TURN_ON_BLUETOOTH = 3;
}
