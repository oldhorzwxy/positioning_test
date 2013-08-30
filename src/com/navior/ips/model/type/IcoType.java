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
 * @date Jul 3, 2013
 */

package com.navior.ips.model.type;

public enum IcoType implements NameValuePair {
  NONE(0, "NONE"), ELVTR(1, "ELVTR"), ESCLTR_NO(2, "ESCLTR_NO"), CSHR(3, "CSHR"), MTLT(
      4, "MTLT"), FTLT(5, "FTLT"), DTLT(6, "DTLT"), ESCLTR_UP(7, "ESCLTR_UP"), SRV(
      8, "SRV"), ENTRNC(9, "ENTRNC"), ESCLTR_TW(10, "ESCLTR_TW"), RRM(11, "RRM"), ESCLTR_DN(
      12, "ESCLTR_DN"), PU(13, "PU"), ESCLTR(14, "ESCLTR"), TLT(15, "TLT"), EXT(
      16, "EXT"), SR(17, "SR"), ATM(18, "ATM"), INFO(19, "INFO"), TX(20, "TX"), UGPKG(
      21, "UGPKG"), DPHN(22, "DPHN"), PHN(23, "PHN"), DCSHR(24, "DCSHR"), OFFC(
      25, "OFFC"), SUBWAY(26, "SUBWAY"), IRM(27, "IRM"), DELVTR(28, "DELVTR"), CA(
      29, "CA"), CTCE(30, "CTCE"), BPB(31, "BPB"), BFN(32, "BFN"), VIP(33,
      "VIP"), BBR(34, "BBR"), TICK(35, "TICK"), LNG(36, "LNG"), SMK(37, "SMK"), MRCE(
      38, "MRCE"), GELVTR(39, "GELVTR"), TR(40, "TR"), COFF(41, "COFF"), SMLS(
      42, "SMLS"), SHCAR(43, "SHCAR"), BANK(44, "BANK"), VLCT(45, "VLCT"), ELVTR_NO(
      46, "ELVTR_NO"), WR(47, "WR"), WASH(48, "WASH"), WCAB(49, "WCAB"), GC(50,
      "GC"), LR(51, "LR"), HWAT(52, "HWAT"), SHR(53, "SHR"), JAFIX(54, "JAFIX"), BC(
      55, "BC"), SBUS(56, "SBUS"), WATE(57, "WATE"), LUGG(58, "LUGG"), AUSH(59,
      "AUSH"), POLI(60, "POLI"), OPTI(61, "OPTI"), CNC(62, "CNC"), TA(63, "TA"), DSHOP(
      64, "DSHOP"), SAFE(65, "SAFE"), DTP(66, "DTP"), FBCL(67, "FBCL"), OBC(68,
      "OBC"), APTS(69, "APTS"), BI(70, "BI"), CTS(71, "CTS"), MAIL(72, "MAIL"), TSV(
      73, "TSV"), MW(74, "MW"), IGN(75, "IGN"), QTE(76, "QTE"), APM(77, "APM"), LOST(
      78, "LOST"), OSG(79, "OSG"), ATIC(80, "ATIC"), APW(81, "APW"), SHOP(82,
      "SHOP"), ADS(83, "ADS"), VIIA(84, "VIIA"), COACH(85, "COACH"), ASD(86,
      "ASD"), IMN(87, "IMN"), DPTS(88, "DPTS"), HCH(89, "HCH"), ACIN(90, "ACIN");

  private final int value;
  private final String name;

  public String toString() {
    return name;
  }

  IcoType(int value, String name) {
    this.value = value;
    this.name = name;
  }

  public int getValue() {
    return value;
  }

  public String getName() {
    return name;
  }

  public final static IcoType get(int value) {
    for (int i = 0; i < values().length; i++) {
      if (values()[i].value == value) {
        return values()[i];
      }
    }
    return null;
  }
}
