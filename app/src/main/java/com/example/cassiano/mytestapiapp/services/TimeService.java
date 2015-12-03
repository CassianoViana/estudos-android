package com.example.cassiano.mytestapiapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TimeService extends Service {

    private static final String TAG = "App";
    private TimerWorker worker;

    @Override
    public void onCreate() {
        super.onCreate();
        // instancia thread
        worker = new TimerWorker();
        Log.i(TAG, "Serviço iniciado!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // inicia thread
        new Thread(worker).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        worker.parar();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
