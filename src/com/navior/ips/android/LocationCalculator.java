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
 * @date 29/08/13
 */
package com.navior.ips.android;

import com.navior.ips.model.Location;
import com.navior.ips.model.POS;

import java.util.HashMap;
import java.util.Set;

public interface LocationCalculator {
  public Location calculateLocation(Set<RssiRecord> recordSet, HashMap<String, POS> posInfoMap);
}
