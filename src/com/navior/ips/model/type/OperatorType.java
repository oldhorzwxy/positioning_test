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

package com.navior.ips.model.type;

import java.util.ArrayList;
import java.util.List;

public enum OperatorType implements NameValuePair {
  ADMINISTRATOR(1, "管理员"), BUSINESS_MANAGER(2, "业务主管"), OPERATOR(4, "业务员"), VALIDATOR(
      8, "检验员");

  private final int value;
  private final String name;

  OperatorType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static OperatorType get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }

  public final static List<OperatorType> getOperatorTypes(int value) {
    List<OperatorType> types = new ArrayList<OperatorType>();
    for (int i = 0; i < values().length; i++) {
      if ((values()[i].value & value) == values()[i].value) {
        types.add(values()[i]);
      }
    }
    return types;
  }
}
