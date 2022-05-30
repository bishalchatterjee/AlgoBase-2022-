package com.bishal.algobase;

import android.app.Application;

import com.onesignal.OneSignal;


public class AppNotificationApplication extends Application {
    private static final String ONESIGNAL_APP_ID = "db2e57aa-62a5-4400-a6f1-bd8cc07a3b01"; //bishalc4300gmail.com(ONE SIGNAL)//notification

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
