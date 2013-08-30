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
 * @date 16/08/13
 */
package com.navior.ips.android;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.navior.ips.model.Location;
import com.navior.ips.model.POS;
import com.navior.test.positioning.DrawPoint;
import com.samsung.android.sdk.bt.gatt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LocatingService extends Service {

  /**
   * State representations.
   * After this service is started, some fields of it may not have been initialized. So it may be not ready to start locating.
   * Outside caller can get the state representation by calling getServiceState() through binder.
   */
  public enum LocatingServiceState {
    NOT_READY_TO_LOCATE,
    READY_TO_LOCATE,
    LOCATING;
  }

  private LocatingServiceState state = LocatingServiceState.NOT_READY_TO_LOCATE;
  private Locator locator;
  private Handler outsideHandler;
  private BroadcastReceiver mReceiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
      String action = intent.getAction();
      if( action != null ) {
        if( action.equals( BluetoothAdapter.ACTION_STATE_CHANGED ) ) {
          int state = intent.getIntExtra( BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR );
          if( state == BluetoothAdapter.STATE_OFF ) {
            Message msg = new Message();
            msg.what = LocationMessage.TO_TURN_ON_BLUETOOTH;
            msg.setTarget( outsideHandler );
            msg.sendToTarget();
          }
        }
      }
    }
  };

  /**
   * To caller: Never call this method!
   */
  @Override
  public void onCreate() {
    super.onCreate();
  }

  /**
   * To caller: Never call this method!
   * @param intent
   * @param flags
   * @param startId
   * @return
   */
  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    locator = new Locator();
    IntentFilter filter = new IntentFilter( BluetoothAdapter.ACTION_STATE_CHANGED );
    registerReceiver( mReceiver, filter );
    return super.onStartCommand(intent, flags, startId);
  }

  /**
   * To caller: Never call this method!
   * @param intent
   * @return
   */
  @Override
  public IBinder onBind(Intent intent) {
    return new LocatingBinder();
  }

  /**
   * To caller: Never call this method!
   */
  @Override
  public void onDestroy() {
    locator = null;
    unregisterReceiver( mReceiver );
    super.onDestroy();
  }

  /**
   * Ask for caller for info about POS.
   * Caller should call setPOSInfo of this service to deliver the information to this service when the info is available.
   * @param posDeviceName
   */
  private void requestForPOSInfo( String posDeviceName ) {
    if(outsideHandler == null) {
      return;
    }
    Message msg = new Message();
    msg.what = LocationMessage.UNKNOWN_POS;
    msg.obj = posDeviceName;
    msg.setTarget(outsideHandler);
    msg.sendToTarget();
  }

  /**
   * Deliver the new location to outside activity.
   * @param location
   */
  private void deliverCurrentLocation( Location location ) {
    if( outsideHandler == null ) {
      System.out.println( "no handler" );
      return;
    }
    Message msg = new Message();
    msg.what = LocationMessage.NEW_LOCATION;
    msg.setTarget(outsideHandler);
    msg.obj = location;
    msg.sendToTarget();
  }

  private void notifyFailToStartLocating() {
    if( outsideHandler == null ) {
      return;
    }
    Message msg = new Message();
    msg.what = LocationMessage.FAIL_START_LOCATING;
    msg.setTarget(outsideHandler);
    msg.sendToTarget();
  }

  public class LocatingBinder extends Binder {
    /**
     * After this service is bounded, the caller must call this method to start locating process.
     * This is important that this service need a caller's handler to send message to,\
     *  such as to request for turning on Bluetooth device, for point of star information and delivering error message.
     * Message format has been defined in previous discussion.
     * NOTE: [1] Caller is responsible for keep the handler alive( accessible ).\
     *  Or a NullPointer exception will happen when this service is trying to send message to caller.
     *  [2] The caller may get true result, but it's not guaranteed to have started locating. A true value just indicates the service's state is OK.\
     *   Caller will receive further message about the locating status, such as it failed to start locating.
     * @param handler the caller's handler
     * @return true if the service's state is OK. false if service cannot start locating at present.
     */
    public boolean startLocating( Handler handler ) {
      if(state == LocatingServiceState.NOT_READY_TO_LOCATE) {
        return false;
      }
      outsideHandler = handler;
      locator.startLocating();
      return true;
    }

    /**
     * Get current location from this service.
     * If the location is not available, the result will be null. This may be the result for some of the following reasons:
     *  [1] Bluetooth device not available
     *  [2] lack of point of star information
     *  [3] not enough point of stars, not strong enough in signal strength or not enough device amount
     *  [4] fatal error happens
     * NOTE: This service is not responsible for the location's accuracy in current version. It may be an out of date location or a little far from real spot.
     * @return
     */
    public Location getLocation() {
      if(outsideHandler == null) {
        return null;
      }
      return locator.getLocation();
    }

    /**
     * Caller call this method to deliver the POS data of certain point of star to this service.
     * Code in this method will be executed in caller's thread.\
     *  Don't worry. It's simple code and will not block the caller.
     * NOTE: This service may be blocked before for lack of POS information. Though this method is called now,\
     *  this service may not continue running since it may still lack other POS info.
     * @param posDeviceName Star name. This parameter cannot be null since the local storage will make use of the star's device name\
     *                      for locating. And it's helpful for locator to know which star the POS information belongs to.
     * @param pos POS data
     */
    public void setPOSInfo( String posDeviceName, POS pos ) {
      locator.addNewPos(posDeviceName, pos);
    }

    public void stopLocating() {
      if(outsideHandler == null) {
        return;
      }
      locator.stopLocating();
      outsideHandler = null;
    }

    public LocatingServiceState getServiceState() {
      return state;
    }
    //-------------------------
    // code for debug
    //-------------------------
    // todo delete the code
    public HashMap<String, DrawPoint> getStarMap() {
      return locator.starMap;
    }
    //-------------------------
    // end of code for debug
    //-------------------------
  }

  /**
   * Locator class for the service.
   * //todo
   */
  private class Locator {

    //-------------------------
    // code for debug
    //-------------------------
    // todo delete the code
    HashMap<String, DrawPoint> starMap;
    //-------------------------
    // end of code for debug
    //-------------------------

    private final static long CLOCK_PERIOD = 2000;
    private final static int SCANNING_PERIOD_ENDS = 357;

    private Location location;
    private LocationCalculator locationCalculator;

    private HashMap< String, POS > posInfoMap;
    private RssiStorage tempStorage;
    private Thread clock;
    private Handler handler = new Handler() {

      @Override
      public void handleMessage(Message msg) {
        System.out.println( "receive message" );
        if (msg.what == SCANNING_PERIOD_ENDS) {
          System.out.println( "ringing.." + System.currentTimeMillis() );
          tempStorage.switchList();
          ArrayList<RssiRecord> records = tempStorage.getLastRecordList();
          Set<RssiRecord> rssiAverageSet = getAverage( records );
          location = locationCalculator.calculateLocation(rssiAverageSet, posInfoMap);
          if(location != null) {
            deliverCurrentLocation( location );

            //-------------------------
            // code for debug
            //-------------------------
            // todo delete the code
            starMap = ((CalculatorWithCOM)locationCalculator).getStarMap();
            //-------------------------
            // end of code for debug
            //-------------------------
          }
          else {
            System.out.println("fail locate");
          }
        }
      }
    };

    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mCallback = new BluetoothGattCallback() {

      @Override
      public void onAppRegistered(int i) {
        state = LocatingServiceState.READY_TO_LOCATE;
      }

      @Override
      public void onScanResult( BluetoothDevice bluetoothDevice, int rssi, byte[] bytes ) {
        String deviceName = bluetoothDevice.getName();
        if(!posInfoMap.containsKey( deviceName )) {
          requestForPOSInfo( deviceName );
          posInfoMap.put( deviceName, null ); // then the star map contains this key and will only deliver the request for one time
        }
        RssiRecord record = new RssiRecord(bluetoothDevice.getName(), rssi);
        tempStorage.addNewRecord( record );
      }
    };
    private BluetoothProfile.ServiceListener mServiceListener = new BluetoothProfile.ServiceListener() {
      @Override
      public void onServiceConnected(int profile, BluetoothProfile bluetoothProfile) {
        System.out.println( "bluetooth connected" );
        if( profile == BluetoothGattAdapter.GATT ) {
          mBluetoothGatt = ( BluetoothGatt )bluetoothProfile;
          mBluetoothGatt.registerApp( mCallback );
          System.out.println( "bluetooth connected" );
        }
      }

      @Override
      public void onServiceDisconnected(int i) {
        mBluetoothGatt.unregisterApp();
        mBluetoothGatt = null;
        state = LocatingServiceState.NOT_READY_TO_LOCATE;
        System.out.println( "bluetooth disconnected" );
      }
    };

    private Locator() {
      posInfoMap = new HashMap<String, POS>();
      location = null;
      locationCalculator = new CalculatorWithCOM();
      tempStorage = new RssiStorage();

      mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if( !mBluetoothAdapter.isEnabled() ) {
        // TODO tell caller to open bluetooth
      }
      BluetoothGattAdapter.getProfileProxy(LocatingService.this, mServiceListener, BluetoothGattAdapter.GATT);
    }

    private void startLocating() {
      if( !mBluetoothGatt.startScan() ) {
        notifyFailToStartLocating();
      }
      else {
        clock = new Clock();
        clock.start();
        state = LocatingServiceState.LOCATING;
      }
    }

    private void stopLocating() {
      clock.interrupt();
      mBluetoothGatt.stopScan();
      clock = null;
    }

    private Location getLocation() {
      return null;
    }

    private void addNewPos(String name, POS pos) {
      posInfoMap.put(name, pos);
    }

    /**
     *
     * @param originalRecords
     * @return a hash set contains the records of average RSSI for each star
     */
    private HashSet<RssiRecord> getAverage( ArrayList<RssiRecord> originalRecords ) {
      HashMap<String, ArrayList< RssiRecord >> classifiedRecords = new HashMap<String, ArrayList<RssiRecord>>();  // map from star name to records of that star
      // classify the records by star name
      for( RssiRecord record : originalRecords ) {
        String starName = record.getStarName();
        if (!classifiedRecords.containsKey( starName )) {
          ArrayList<RssiRecord> recordList = new ArrayList<RssiRecord>();
          recordList.add( record );
          classifiedRecords.put(starName, recordList);
        } else {
          classifiedRecords.get(starName).add( record );
        }
      }
      // compute average for each list
      Set<String> keySet = classifiedRecords.keySet();
      HashSet<RssiRecord> result = new HashSet<RssiRecord>();
      ArrayList<RssiRecord> classifiedList; // record list for one star
      for( String name : keySet ) {
        classifiedList = classifiedRecords.get(name);
        int totalRssi = 0;
        for (RssiRecord record : classifiedList) {
          totalRssi += record.getRssi();
        }
        totalRssi /= classifiedList.size();
        result.add(new RssiRecord(name, totalRssi));
      }
      return result;
    }

    @Override
    protected void finalize() throws Throwable {
      // TODO gracefully exit when exception occurred
      if (mBluetoothGatt != null) {
        mBluetoothGatt.stopScan();
        BluetoothGattAdapter.closeProfileProxy( BluetoothGattAdapter.GATT, mBluetoothGatt );
      }
      else {
        // todo null pointer
      }
      super.finalize();
    }

    private class Clock extends Thread {
      @Override
      public void run() {
        try {
          while (true) {
            Thread.sleep(CLOCK_PERIOD);
            System.out.println("clock wakes up");
            Message msg = new Message();
            msg.what = SCANNING_PERIOD_ENDS;
            msg.setTarget(handler);
            msg.sendToTarget();
            System.out.println("sent message");
          }
        } catch (InterruptedException e) {
          // It's normal. Nothing to do.
        }
      }
    }

    /**
     * Native storage of discovered RSSI and device name pair.
     * The storage has two list: one for inserting new record, the other for getting records out.
     * The two lists are not under use by the same thread at the same moment: the inserting thread writes ine list, \
     *  while the locating thread reads the other one.\
     *  Once after certain time, the uses of two lists are exchanged: the read list is cleared for future writing and the written one is sent outside storage.
     */
    private class RssiStorage {

      private Object writeLock = new Object();

      private ArrayList< RssiRecord > readList;
      private ArrayList< RssiRecord > writtenList;

      RssiStorage() {
        writtenList = new ArrayList<RssiRecord>();
        readList = new ArrayList<RssiRecord>();
      }

      /**
       * Add a new record into the list.
       * This method will be called by Bluetooth service thread( created outside this process ).\
       *  So no need to branch a new thread dealing with writing logic.
       * @param rssiRecord record model, which is a RSSI and star name pair
       */
      public void addNewRecord(RssiRecord rssiRecord) {
        synchronized ( writeLock ) {
          writtenList.add(rssiRecord);
        }
      }

      /**
       * Switch the written list and read list.
       * It's a thread-safe method.
       */
      public void switchList() {
        synchronized ( writeLock ) {
          readList = writtenList;
          writtenList = new ArrayList<RssiRecord>();
        }
      }

      /**
       * Get the records of the last period.
       * The result will not be modified by scanning thread. It has been replaced with a new one in the locator.
       * Strongly recommend to call this after calling switchList(). Or the results are not of last period.
       * @return list of records
       */
      public ArrayList<RssiRecord> getLastRecordList() {
        return readList;
      }
    }
  }
}
