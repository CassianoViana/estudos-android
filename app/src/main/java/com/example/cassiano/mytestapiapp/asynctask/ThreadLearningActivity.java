package com.example.cassiano.mytestapiapp.asynctask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.MyHandler;
import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 20/11/2015.
 */
public class ThreadLearningActivity extends Activity {

    private TextView taskLabel;
    //private Handler handler = new Handler();
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_learning);

        taskLabel = (TextView) findViewById(R.id.campo_texto);
        handler = new MyHandler(taskLabel);

    }

    public void processar(View view) {

        taskLabel.setText("Iniciou!");
        iniciaTarefaDemorada();

    }

    private void iniciaTarefaDemorada() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(15000);

                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        taskLabel.setText("Pronto!");
                    }
                });*/

                /*handler.post(new Runnable() {
                    @Override
                    public void run() {
                        taskLabel.setText("Pronto!");
                    }
                });*/

                Message msg = Message.obtain(handler);
                msg.what = MyHandler.UPDATE_UI;
                Bundle data = new Bundle();
                data.putString("texto", "Tarefa finalizada!");
                msg.setData(data);
                handler.sendMessage(msg);
            }
        }).start();
    }
}
