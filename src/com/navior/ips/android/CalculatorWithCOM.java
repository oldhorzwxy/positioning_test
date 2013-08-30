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

import android.graphics.Color;
import com.navior.ips.model.Location;
import com.navior.ips.model.POS;
import com.navior.test.positioning.DrawPoint;

import java.util.*;

public class CalculatorWithCOM implements LocationCalculator {

  private final static int LEAST_STAR_AMOUNT = 4;


  //-------------------------
  // code for debug
  //-------------------------
  // todo
  private HashMap<String, DrawPoint> starMap;
  //-------------------------
  // end of code for debug
  //-------------------------

  @Override
  public Location calculateLocation(Set<RssiRecord> recordSet, HashMap< String, POS > posInfoMap) {
    //-------------------------
    // code for debug
    //-------------------------
    // todo
    starMap = new HashMap<String, DrawPoint>();
    //-------------------------
    // end of code for debug
    //-------------------------


    TreeSet<RssiRecord> sortedRecordSet = new TreeSet<RssiRecord>( new RssiComparator() );
    sortedRecordSet.addAll( recordSet );
    RssiRecord strongestStarRecord = sortedRecordSet.pollLast();
    POS strongestStar = posInfoMap.get(strongestStarRecord.getStarName());
    // check star info
    if( strongestStar == null ) {
      return null;
    }
    // todo cannot deal with two floor with same strong records
    int floorId = posInfoMap.get(strongestStarRecord.getStarName()).getFloorId();
    ArrayList<RssiRecord> cooperatedStars = new ArrayList<RssiRecord>();
    ArrayList<Float> distanceList = new ArrayList<Float>();
    RssiRecord addedRecord = sortedRecordSet.pollLast();
    while( addedRecord != null && cooperatedStars.size() < LEAST_STAR_AMOUNT - 1 ) {
      String name = addedRecord.getStarName();
      POS addedStar = posInfoMap.get( name );
      if( addedStar == null ) {
        // not enough info about stars
        return null;
      }
      else if( addedStar.getFloorId() == floorId ) {
        cooperatedStars.add( addedRecord );
        distanceList.add(rssi2Distance(addedRecord.getRssi()));

        //-------------------------
        // code for debug
        //-------------------------
        // todo
        DrawPoint point = new DrawPoint();
        point.color = Color.CYAN;
        point.x = (int)addedStar.getX();
        point.y = (int)addedStar.getY();
        point.rssi = addedRecord.getRssi();
        point.label = name;
        point.r = (int)rssi2Distance(addedRecord.getRssi());
        starMap.put(name, point);

        //-------------------------
        // end of code for debug
        //-------------------------
      }
      addedRecord = sortedRecordSet.pollLast();
    }
    // not enough stars to do calculation
    if( cooperatedStars.size() < LEAST_STAR_AMOUNT - 1 ) {
      return null;
    }

    float comX = 0f;
    float comY = 0f;
    float divider = 0f;
    float product = 1f;
    for(int i = 0; i < LEAST_STAR_AMOUNT - 1; i++) {
      product *= distanceList.get(i);
    }
    for(int i = 0; i < LEAST_STAR_AMOUNT - 1; i++) {
      float weight = product / distanceList.get(i);
      POS pos = posInfoMap.get( cooperatedStars.get(i).getStarName() );
      comX += weight * pos.getX();
      comY += weight * pos.getY();
      divider += weight;
    }
    comX /= divider;
    comY /= divider;
    //-------------------------
    // code for debug
    //-------------------------
    // todo
    DrawPoint com = new DrawPoint();
    com.x = (int)comX;
    com.y = (int)comY;
    com.rssi = -10;
    com.label = "com";
    com.r = 100;
    com.color = Color.GREEN;
    starMap.put("gravity", com);
    //-------------------------
    // end of code for debug
    //-------------------------
    float sR = rssi2Distance(strongestStarRecord.getRssi());
    float sX = strongestStar.getX();
    float sY = strongestStar.getY();

    //-------------------------
    // code for debug
    //-------------------------
    // todo
    DrawPoint s = new DrawPoint();
    s.x = (int)sX;
    s.y = (int)sY;
    s.rssi = strongestStarRecord.getRssi();
    s.label = strongestStarRecord.getStarName();
    s.r = (int)sR;
    s.color = Color.RED;
    starMap.put(strongestStarRecord.getStarName(), s);
    //-------------------------
    // end of code for debug
    //-------------------------
    float d = (float)Math.sqrt( (comX - sX) * (comX - sX) + (comY - sY) * (comY - sY) );
    float resultX = (comX - sX) * sR / d + sX;
    float resultY = (comY - sY) * sR / d + sY;
    Location result = new Location();
    result.setX(resultX);
    result.setY(resultY);
    result.setLocTime(new Date());
    result.setFloorId(floorId);
    return result;
  }

  /**
   * Comparator for RssiRecords. Used by TreeSet.
   * It has two-level comparing logic. First by RSSI value. Then by star name.
   */
  private class RssiComparator implements Comparator<RssiRecord> {
    @Override
    public int compare(RssiRecord rssiRecord1, RssiRecord rssiRecord2) {
      int result = rssiRecord1.getRssi() - rssiRecord2.getRssi();
      if(result == 0) {
        result = rssiRecord1.getStarName().compareTo( rssiRecord2.getStarName() );
      }
      return result;
    }
  }

  /**
   * Replaceable algorithm.
   * @param rssi
   * @return
   */
  private static float rssi2Distance( int rssi ) {
    return 100 * (float)Math.pow(2, (-55 - rssi) / 5.0);
  }

  //-------------------------
  // code for debug
  //-------------------------
  // todo

  public HashMap<String, DrawPoint> getStarMap() {
    return starMap;
  }

  //-------------------------
  // end of code for debug
  //-------------------------
}
