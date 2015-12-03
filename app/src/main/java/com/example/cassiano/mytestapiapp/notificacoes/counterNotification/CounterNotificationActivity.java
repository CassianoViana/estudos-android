package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cassiano.mytestapiapp.R;

public class CounterNotificationActivity extends AppCompatActivity implements CounterFragment.OnFragmentInteractionListener, CounterNotificationManager.OnNotificationInterationListener {

    private CounterNotificationManager notificationManager;
    private CounterTask counterTask;
    private CounterFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_notification);
    }

    @Override
    public void iniciaContagem() {

        notificationManager = new CounterNotificationManager(this);
        fragment = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.counterFragment);

        counterTask = new CounterTask();
        counterTask.addCounterListener(fragment);
        counterTask.addCounterListener(notificationManager);

        int max = 1000;
        if (counterTask.getStatus() != AsyncTask.Status.RUNNING) {
            counterTask.execute(max);
        }
        fragment.contagemIniciou(max);
    }

    @Override
    public void cancelar() {
        counterTask.cancel(false);
    }
}