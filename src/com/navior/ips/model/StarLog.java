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

import com.navior.ips.model.type.StarState;

import java.io.Serializable;
import java.util.Date;

public class StarLog implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 3190924721254498243L;
  private int id;
  private Star star;
  private Operator operator;
  private StarState beforeState;
  private StarState afterState;
  private Date optime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Star getStar() {
    return star;
  }

  public void setStar(Star star) {
    this.star = star;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public StarState getBeforeState() {
    return beforeState;
  }

  public void setBeforeState(StarState beforeState) {
    this.beforeState = beforeState;
  }

  public StarState getAfterState() {
    return afterState;
  }

  public void setAfterState(StarState afterState) {
    this.afterState = afterState;
  }

  public Date getOptime() {
    return optime;
  }

  public void setOptime(Date optime) {
    this.optime = optime;
  }

  public final static StarLog buildLog(Star star, Operator operator,
                                       StarState beforeState, StarState afterState) {
    if (star != null && operator != null && beforeState != null
        && afterState != null) {
      StarLog log = new StarLog();
      log.setStar(star);
      log.setBeforeState(beforeState);
      log.setAfterState(afterState);
      log.setOperator(operator);
      return log;
    } else {
      return null;
    }
  }
}
