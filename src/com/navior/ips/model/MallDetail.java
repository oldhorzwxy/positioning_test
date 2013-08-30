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
 * @date Jun 25, 2013
 */

package com.navior.ips.model;

import java.io.Serializable;

public class MallDetail implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -1144652747126942566L;
  private int id;
  private String sinatopic;
  private String bus;
  private String phone;
  private String open;
  private String brief;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSinatopic() {
    return sinatopic;
  }

  public void setSinatopic(String sinatopic) {
    this.sinatopic = sinatopic;
  }

  public String getBus() {
    return bus;
  }

  public void setBus(String bus) {
    this.bus = bus;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getOpen() {
    return open;
  }

  public void setOpen(String open) {
    this.open = open;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

}
