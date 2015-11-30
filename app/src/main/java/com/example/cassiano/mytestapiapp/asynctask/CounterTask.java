package com.example.cassiano.mytestapiapp.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Cassiano on 20/11/2015.
 */
public class CounterTask extends AsyncTask<Integer, Integer, Void> {

    private TextView textView;
    private Button button;

    public CounterTask(Button button, TextView textView) {
        this.button = button;
        this.textView = textView;
    }

    @Override
    protected Void doInBackground(Integer... params) {
        int max = params[0];

        int count = 0;
        for(int i = 0; i < max; i++){
            SystemClock.sleep(500);
            count++;
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        button.setEnabled(false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        button.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText(String.valueOf(values[0]));
    }
}
