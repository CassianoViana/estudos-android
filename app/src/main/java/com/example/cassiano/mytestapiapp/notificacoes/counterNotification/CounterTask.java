package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassiano on 02/12/2015.
 */
public class CounterTask extends AsyncTask<Integer, Integer, Void> {

    private List<CounterListener> listeners;

    public CounterTask() {
        listeners = new ArrayList<>();
    }

    public void addCounterListener(CounterListener listener) {
        this.listeners.add(listener);
    }

    public void removeCounterListener(CounterListener listener) {
        this.listeners.remove(listener);
    }

    private int max;

    @Override
    protected Void doInBackground(Integer... params) {

        max = params[0];
        int count = 0;
        while(!isCancelled() && count < max){
            SystemClock.sleep(1000);
            publishProgress(count);
            Log.d("counter", "Contador:" + count);
            count ++;
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        for (CounterListener listener : listeners) {
            listener.contagemIniciou(max);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        for (CounterListener listener : listeners) {
            listener.contagemFinalizou(false);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        for (CounterListener listener : listeners) {
            listener.contagemAlterou(values[0]);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        for (CounterListener listener : listeners) {
            listener.contagemFinalizou(false);
        }
    }
}
