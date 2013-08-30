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

import com.navior.ips.model.type.OperatorType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Operator implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -336636453478661756L;

  private int id;
  private String username;
  private String password;
  private String realname;
  private String idcard;
  private String address;
  private String mobile;
  private String tele;
  private String fax;
  private String qq;
  private String msn;
  private List<OperatorType> types;
  private Date registTime;
  private Date lastModified;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public String getIdcard() {
    return idcard;
  }

  public void setIdcard(String idcard) {
    this.idcard = idcard;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getTele() {
    return tele;
  }

  public void setTele(String tele) {
    this.tele = tele;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }

  public String getMsn() {
    return msn;
  }

  public void setMsn(String msn) {
    this.msn = msn;
  }

  public List<OperatorType> getTypes() {
    return types;
  }

  public void setTypes(List<OperatorType> types) {
    this.types = types;
  }

  public Date getRegistTime() {
    return registTime;
  }

  public void setRegistTime(Date registTime) {
    this.registTime = registTime;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

  public String toString() {
    return realname;
  }
}
