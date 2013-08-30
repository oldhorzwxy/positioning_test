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
 * @date 21/08/13
 */
package com.navior.test.positioning;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.navior.ips.android.LocatingService;
import com.samsung.android.sdk.bt.gatt.BluetoothGatt;
import com.samsung.android.sdk.bt.gatt.BluetoothGattAdapter;
import com.samsung.android.sdk.bt.gatt.BluetoothGattCallback;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LocatingActivity extends Activity {

  private HashMap<String, Star> starMap;
  private MapGraph mapGraph;
  private Handler handler;

  private LocatingService.LocatingBinder binder;
  private ServiceConnection connection = new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
      binder = (LocatingService.LocatingBinder)iBinder;
      System.out.println("bind locating service");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
      binder = null;
      System.out.println("unbind locating service");
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView( R.layout.activity_locating );

    starMap = new HashMap<String, Star>();
    handler = new Handler() {
      @Override
      public void handleMessage(Message msg) {

      }
    };

    Button set_stars = (Button) findViewById(R.id.set_stars);
    set_stars.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LocatingActivity.this, SettingActivity.class);
        startActivity(intent);
      }
    });
    Button start_locating = (Button) findViewById(R.id.start_locating);
    start_locating.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        binder.startLocating( handler );
      }
    });
    Button clear = (Button) findViewById(R.id.clear);
    clear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        mapGraph.setPointMap( null );
        mapGraph.postInvalidate();
      }
    });
    Button quit = (Button)findViewById(R.id.quit);
    quit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        LocatingActivity.this.finish();
      }
    });

    mapGraph = new MapGraph(this);
    ( (ViewGroup)findViewById(R.id.result_area) ).addView(mapGraph);

    Intent intent = new Intent( LocatingActivity.this, LocatingService.class);
    startService(intent);
    bindService(intent, connection, BIND_AUTO_CREATE );
  }

  @Override
  protected void onResume() {
    super.onResume();

    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader( openFileInput("stars") ) );
      while (reader.ready()){
        String line = reader.readLine();
        String[] parts = line.split(" ");
        String name = parts[0];
        String x = parts[1];
        String y = parts[2];
        starMap.put(name, new Star(name, Integer.parseInt(x), Integer.parseInt(y)));
      }
      reader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void onDestroy() {
    unbindService(connection);
    super.onDestroy();
  }
}
