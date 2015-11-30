package com.example.cassiano.mytestapiapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.asynctask.CounterTask;

/**
 * Created by Cassiano on 20/11/2015.
 */
public class AsyncTaskLearningActivity extends Activity {

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_learning);

        textView = (TextView) findViewById(R.id.textoContagem);
        button = (Button) findViewById(R.id.btnContar);
    }

    public void iniciarContagem(View view) {
        CounterTask counterTask = new CounterTask(button, textView);
        counterTask.execute(10);
    }
}
