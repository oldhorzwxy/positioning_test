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

package com.navior.ips.model.type;

public enum StarState implements NameValuePair {
  INIT(10, "生成"), BURN(20, "烧录"), TEST(30, "测试"), EXPORT(35, "导出"), PACKAGE(40,
      "打包"), EXPRESS(50, "快递"), READY(60, "准备"), WORK(70, "工作"), FAULT(80, "故障"), RETRIEVE(
      90, "回收"), END(100, "终结");

  private final int value;
  private final String name;

  StarState(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static StarState get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }
}
