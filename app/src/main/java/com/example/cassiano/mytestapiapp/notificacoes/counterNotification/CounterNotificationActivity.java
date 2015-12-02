package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.app.Notification;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

public class CounterNotificationActivity extends AppCompatActivity implements CounterFragment.OnFragmentInteractionListener {

    private CounterNotificationManager notificationManager;
    private CounterTask counterTask;
    private CounterFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_notification);

        notificationManager = new CounterNotificationManager(this);

        counterTask = new CounterTask();
        fragment = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.counterFragment);

        counterTask.addCounterListener(fragment);
        counterTask.addCounterListener(notificationManager);
    }

    @Override
    public void iniciaContagem() {
        int max = 100;
        if (counterTask.getStatus() != AsyncTask.Status.RUNNING) {
            counterTask.execute(max);
        }
        fragment.contagemIniciou(max);
    }
}