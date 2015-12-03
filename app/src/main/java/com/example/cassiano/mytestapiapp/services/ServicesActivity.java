package com.example.cassiano.mytestapiapp.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 03/12/2015.
 */
public class ServicesActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void iniciar(View view) {
        intent = new Intent(getApplicationContext(), TimeService.class);
        startService(intent);
    }

    public void parar(View view) {
        if (intent != null) {
            stopService(intent);
        }
    }
}
