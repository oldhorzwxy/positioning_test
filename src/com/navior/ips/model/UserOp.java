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
 * @date Jul 14, 2013
 */

package com.navior.ips.model;

import com.navior.ips.model.type.UserOpType;

import java.io.Serializable;
import java.util.Date;

public class UserOp implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 5025124920098260417L;

  private int id;
  private long userId;
  private int op;
  private Date opTime;

  private UserOp() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public int getOp() {
    return op;
  }

  public void setOp(int op) {
    this.op = op;
  }

  public Date getOpTime() {
    return opTime;
  }

  public void setOpTime(Date opTime) {
    this.opTime = opTime;
  }

  public final static UserOp buildOp(EndUser user, UserOpType opType) {
    if (user != null && opType != null) {
      UserOp op = new UserOp();
      op.setUserId(user.getId());
      op.setOp(opType.getValue());
      return op;
    } else {
      return null;
    }
  }
}
