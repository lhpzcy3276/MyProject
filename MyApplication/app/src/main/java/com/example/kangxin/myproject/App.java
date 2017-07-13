// (c)2016 Flipboard Inc, All Rights Reserved.

package com.example.kangxin.myproject;

import android.app.Application;

import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        Realm.init(this);
        RealmConfiguration configuration=new  RealmConfiguration.Builder()
                .name("myRealm.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);


        //growing 无埋点统计
        GrowingIO.startWithConfiguration(this,new Configuration().useID()
        .trackAllFragments()
        .setChannel("应用宝"));
    }
}
