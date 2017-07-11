package com.example.kangxin.myproject.activity;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.kangxin.myproject.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Android6.0权限
 * http://www.cnblogs.com/whoislcj/p/6090795.html
 */
public class Android6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android6);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.permission_one,R.id.permission_more})
    public void myClick(View view){
        switch (view.getId()){
            case R.id.permission_one:
                RxPermissions.getInstance(this)
                        .request(Manifest.permission.CAMERA)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(@NonNull Boolean aBoolean) throws Exception {
                                if (aBoolean){
                                    Toast.makeText(Android6Activity.this,"获取一个权限",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Android6Activity.this,"获取一个权限失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
            case R.id.permission_more:
                RxPermissions.getInstance(this)
                        .request(Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(@NonNull Boolean aBoolean) throws Exception {
                                if (aBoolean){
                                    Toast.makeText(Android6Activity.this,"获取多个权限",Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Android6Activity.this,"获取多个权限失败",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
        }
    }
}
/**
 * 普通权限
 * Normal Permissions如下
 ACCESS_LOCATION_EXTRA_COMMANDS
 ACCESS_NETWORK_STATE
 ACCESS_NOTIFICATION_POLICY
 ACCESS_WIFI_STATE
 BLUETOOTH
 BLUETOOTH_ADMIN
 BROADCAST_STICKY
 CHANGE_NETWORK_STATE
 CHANGE_WIFI_MULTICAST_STATE
 CHANGE_WIFI_STATE
 DISABLE_KEYGUARD
 EXPAND_STATUS_BAR
 GET_PACKAGE_SIZE
 INSTALL_SHORTCUT
 INTERNET
 KILL_BACKGROUND_PROCESSES
 MODIFY_AUDIO_SETTINGS
 NFC
 READ_SYNC_SETTINGS
 READ_SYNC_STATS
 RECEIVE_BOOT_COMPLETED
 REORDER_TASKS
 REQUEST_INSTALL_PACKAGES
 SET_ALARM
 SET_TIME_ZONE
 SET_WALLPAPER
 SET_WALLPAPER_HINTS
 TRANSMIT_IR
 UNINSTALL_SHORTCUT
 USE_FINGERPRINT
 VIBRATE
 WAKE_LOCK
 WRITE_SYNC_SETTINGS

 ------------------------------------------------
 危险权限
 Dangerous Permissions:
 group:android.permission-group.CONTACTS
 permission:android.permission.WRITE_CONTACTS
 permission:android.permission.GET_ACCOUNTS
 permission:android.permission.READ_CONTACTS

 group:android.permission-group.PHONE
 permission:android.permission.READ_CALL_LOG
 permission:android.permission.READ_PHONE_STATE
 permission:android.permission.CALL_PHONE
 permission:android.permission.WRITE_CALL_LOG
 permission:android.permission.USE_SIP
 permission:android.permission.PROCESS_OUTGOING_CALLS
 permission:com.android.voicemail.permission.ADD_VOICEMAIL

 group:android.permission-group.CALENDAR
 permission:android.permission.READ_CALENDAR
 permission:android.permission.WRITE_CALENDAR

 group:android.permission-group.CAMERA
 permission:android.permission.CAMERA

 group:android.permission-group.SENSORS
 permission:android.permission.BODY_SENSORS

 group:android.permission-group.LOCATION
 permission:android.permission.ACCESS_FINE_LOCATION
 permission:android.permission.ACCESS_COARSE_LOCATION

 group:android.permission-group.STORAGE
 permission:android.permission.READ_EXTERNAL_STORAGE
 permission:android.permission.WRITE_EXTERNAL_STORAGE

 group:android.permission-group.MICROPHONE
 permission:android.permission.RECORD_AUDIO

 group:android.permission-group.SMS
 permission:android.permission.READ_SMS
 permission:android.permission.RECEIVE_WAP_PUSH
 permission:android.permission.RECEIVE_MMS
 permission:android.permission.RECEIVE_SMS
 permission:android.permission.SEND_SMS
 permission:android.permission.READ_CELL_BROADCASTS
 */