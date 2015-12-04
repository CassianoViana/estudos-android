package com.example.cassiano.mytestapiapp.services;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

import java.io.Serializable;

/**
 * Created by Cassiano on 03/12/2015.
 */
public class ServicesActivity extends AppCompatActivity {

    private static Intent intent1;
    private static Intent intent2;
    private static TimeService service1;
    private static TimeIntentService service2;
    private static TimeServiceConnection connection1;
    private static TimeIntentServiceConnection connection2;
    private static TextView txtSeconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        txtSeconds = (TextView) findViewById(R.id.txt_seconds);
    }

    public void iniciar(View view) {
        iniciaServico1();
        iniciaServico2();
    }

    private void iniciaServico1() {
        intent1 = new Intent(getApplicationContext(), TimeService.class);
        startService(intent1);
        connection1 = new TimeServiceConnection();
        bindService(intent1, connection1, 0);
    }

    private void iniciaServico2() {
        intent2 = new Intent(getApplicationContext(), TimeIntentService.class);
        startService(intent2);
        connection2 = new TimeIntentServiceConnection();
        bindService(intent2, connection2, 0);
    }

    public void parar(View view) {
        if (intent1 != null) {
            stopService(intent1);
        }
        if (intent2 != null) {
            // nao implementei a parada deste
            stopService(intent2);
        }
    }

    public void lerSegundos(View view) {
        int segundos = service1.getSegundos();
        txtSeconds.setText(String.valueOf(segundos));
    }

    public void lerSegundos2(View view) {
        int segundos = service2.getSegundos();
        txtSeconds.setText(String.valueOf(segundos));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private class TimeServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TimeService.TimeServiceBinder binder = (TimeService.TimeServiceBinder) service;
            ServicesActivity.this.service1 = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }


    private class TimeIntentServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TimeIntentService.TimeIntentServiceBinder binder = (TimeIntentService.TimeIntentServiceBinder) service;
            ServicesActivity.this.service2 = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
