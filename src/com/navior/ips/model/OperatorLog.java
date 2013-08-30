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

package com.navior.ips.model;

import com.navior.ips.model.type.OperateDBType;
import com.navior.ips.model.type.TableName;

import java.io.Serializable;
import java.util.Date;

public class OperatorLog implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -134936760483040545L;

  private int id;

  private Operator operator;

  private OperateDBType opType;

  private TableName tableName;

  private int mainId;

  private Date optime;

  private OperatorLog() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Operator getOperator() {
    return operator;
  }

  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  public OperateDBType getOpType() {
    return opType;
  }

  public void setOpType(OperateDBType opType) {
    this.opType = opType;
  }

  public TableName getTableName() {
    return tableName;
  }

  public void setTableName(TableName tableName) {
    this.tableName = tableName;
  }

  public int getMainId() {
    return mainId;
  }

  public void setMainId(int mainId) {
    this.mainId = mainId;
  }

  public Date getOptime() {
    return optime;
  }

  public void setOptime(Date optime) {
    this.optime = optime;
  }

  public final static OperatorLog buildLog(Operator operator,
                                           TableName tableName, OperateDBType operateDBType, int mainId) {
    if (operator != null && tableName != null && operateDBType != null) {
      OperatorLog log = new OperatorLog();
      log.setOperator(operator);
      log.setTableName(tableName);
      log.setOpType(operateDBType);
      log.setMainId(mainId);
      return log;
    } else {
      return null;
    }
  }
}
