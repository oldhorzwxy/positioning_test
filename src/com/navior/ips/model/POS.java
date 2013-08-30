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

public class POS extends Point2D {

  /**
   *
   */
  private static final long serialVersionUID = -5216964049948011459L;

  private long starSn;

  public long getStarSn() {
    return starSn;
  }

  public void setStarSn(long starSn) {
    this.starSn = starSn;
  }

}
