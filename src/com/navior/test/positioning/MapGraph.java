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
 * @date 27/08/13
 */
package com.navior.test.positioning;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.HashMap;
import java.util.Iterator;

public class MapGraph extends View {

  private final static int PADDING_X = 40;
  private final static int PADDING_Y = 50;

  private final static int MAX_COLUMN = 20;
  private final static int MAX_ROW = 20;

  private final static int BLOCK_SIZE = 50;

  private final static int MARK_LENGTH = 20;

  private HashMap<String, DrawPoint> pointMap;

  MapGraph(Context context) {
    super(context);
    pointMap = null;
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);



    // draw rulers
    Paint painter = new Paint();
    canvas.drawLine( PADDING_X, PADDING_Y, PADDING_X + MAX_COLUMN * BLOCK_SIZE, PADDING_Y, painter );
    canvas.drawLine( PADDING_X, PADDING_Y, PADDING_X, PADDING_Y + MAX_ROW * BLOCK_SIZE, painter );
    for(int i = 0; i < MAX_COLUMN + 1; i++) {
      canvas.drawLine(PADDING_X + i * BLOCK_SIZE, PADDING_Y, PADDING_X + i * BLOCK_SIZE, PADDING_Y - MARK_LENGTH, painter);
      canvas.drawText("" + i, PADDING_X + 5 + i * BLOCK_SIZE, PADDING_Y + 5, painter);
    }
    for(int i = 0; i < MAX_ROW; i++) {
      canvas.drawLine(PADDING_X, PADDING_Y + i * BLOCK_SIZE, PADDING_X - MARK_LENGTH, PADDING_Y + i * BLOCK_SIZE, painter);
      canvas.drawText("" + i, 10, PADDING_Y + i * BLOCK_SIZE - 5, painter);
    }

    // draw walls
    canvas.drawLine( PADDING_X, PADDING_Y, PADDING_X + 365, PADDING_Y, painter ); // 1
    canvas.drawLine( PADDING_X, PADDING_Y, PADDING_X, PADDING_Y + 740, painter ); // 2
    canvas.drawLine( PADDING_X + 365, PADDING_Y, PADDING_X + 365, PADDING_Y + 505, painter ); // 3
    canvas.drawLine( PADDING_X, PADDING_Y + 740, PADDING_X + 860, PADDING_Y + 740, painter ); // 4
    canvas.drawLine( PADDING_X + 365, PADDING_Y + 505, PADDING_X + 620, PADDING_Y + 505, painter ); // 5
    canvas.drawLine( PADDING_X + 365, PADDING_Y + 390, PADDING_X + 585, PADDING_Y + 390, painter ); // 6
    canvas.drawLine( PADDING_X + 585, PADDING_Y + 390, PADDING_X + 585, PADDING_Y + 505, painter ); // 7
    canvas.drawLine( PADDING_X + 515, PADDING_Y + 605, PADDING_X + 685, PADDING_Y + 605, painter ); // 8
    canvas.drawLine( PADDING_X + 515, PADDING_Y + 605, PADDING_X + 515, PADDING_Y + 740, painter ); // 9
    canvas.drawLine( PADDING_X + 685, PADDING_Y + 740, PADDING_X + 685, PADDING_Y + 190, painter ); // 10
    canvas.drawLine( PADDING_X + 860, PADDING_Y + 740, PADDING_X + 860, PADDING_Y + 190, painter ); // 11
    canvas.drawLine( PADDING_X + 685, PADDING_Y + 490, PADDING_X + 860, PADDING_Y + 490, painter ); // 12
    canvas.drawLine( PADDING_X + 685, PADDING_Y + 365, PADDING_X + 860, PADDING_Y + 365, painter ); // 13
    canvas.drawLine( PADDING_X + 620, PADDING_Y + 190, PADDING_X + 860, PADDING_Y + 190, painter ); // 14
    canvas.drawLine( PADDING_X + 620, PADDING_Y + 505, PADDING_X + 620, PADDING_Y + 190, painter ); // 15

    if(pointMap == null) {
      return;
    }

    // draw signal area circles
    Iterator<String> iterator = pointMap.keySet().iterator();
    while(iterator.hasNext()) {
      String name = iterator.next();
      DrawPoint p = pointMap.get(name);
      if(name.equals("gravity")) {
        Paint paint = new Paint();
        paint.setColor(p.color);
        canvas.drawCircle(PADDING_X + p.x * BLOCK_SIZE / 100, PADDING_Y + p.y * BLOCK_SIZE / 100, 3, paint);
        canvas.drawText(p.label, PADDING_X + p.x * BLOCK_SIZE / 100 + 20, PADDING_Y + p.y * BLOCK_SIZE / 100 + 20, paint);
      }
      else if(name.equals("result")) {
        Paint paint = new Paint();
        paint.setColor(p.color);
        canvas.drawCircle(PADDING_X + p.x * BLOCK_SIZE / 100, PADDING_Y + p.y * BLOCK_SIZE / 100, 3, paint);
        canvas.drawText(p.label, PADDING_X + p.x * BLOCK_SIZE / 100 + 20, PADDING_Y + p.y * BLOCK_SIZE / 100 + 20, paint);
      }
      else {
        Paint paint = new Paint();
        canvas.drawCircle(PADDING_X + p.x * BLOCK_SIZE / 100, PADDING_Y + p.y * BLOCK_SIZE / 100, 3, paint);
        canvas.drawText(p.label + "/" + p.rssi, PADDING_X + p.x * BLOCK_SIZE / 100 + 20, PADDING_Y + p.y * BLOCK_SIZE / 100 + 20, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(p.color);
        canvas.drawCircle(PADDING_X + p.x * BLOCK_SIZE / 100, PADDING_Y + p.y * BLOCK_SIZE / 100, p.r * BLOCK_SIZE / 100, paint);
      }
    }
  }

  void setPointMap(HashMap<String, DrawPoint> pointMap) {
    this.pointMap = pointMap;
  }
}
