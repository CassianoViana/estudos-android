package com.example.cassiano.mytestapiapp.services;

import android.app.Service;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by Cassiano on 03/12/2015.
 */
public class TimerWorker implements Runnable {

    private static final String TAG = "App";
    private Service service;
    private volatile boolean rodando;

    @Override
    public void run() {

        int seconds = 0;
        rodando = true;

        while(rodando){
            seconds++;
            Log.i(TAG, "Segundos = "+seconds);
            SystemClock.sleep(1000);
        }

        parar();

    }

    public void parar(){
        rodando = false;
    }
}
