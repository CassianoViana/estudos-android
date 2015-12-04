package com.example.cassiano.mytestapiapp.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class TimeIntentService extends IntentService {

    private static final String TAG = "App";
    private TimeIntentServiceBinder binder = new TimeIntentServiceBinder();

    public TimeIntentService() {
        super("TimeIntentService");
    }

    int segundos = 0;

    @Override
    protected void onHandleIntent(Intent intent) {

        while (true) {
            SystemClock.sleep(3000);
            segundos++;
            Log.i(TAG, "Segundos: " + segundos);
        }
    }

    public int getSegundos() {
        return segundos;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class TimeIntentServiceBinder extends Binder {
        public TimeIntentService getService() {
            return TimeIntentService.this;
        }
    }

}
