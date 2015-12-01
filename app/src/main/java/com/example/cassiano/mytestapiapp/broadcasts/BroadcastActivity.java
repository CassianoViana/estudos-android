package com.example.cassiano.mytestapiapp.broadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 01/12/2015.
 */
public class BroadcastActivity extends AppCompatActivity{

    private MyReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        receiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.cassiano.mytestapiapp.broadcasts.MSG");
        registerReceiver(receiver, intentFilter);
    }

    public void enviar(View view) {
        Intent intent = new Intent("com.example.cassiano.mytestapiapp.broadcasts.MSG");
        intent.putExtra("msg", "Mensagem para BroadcastsReceivers");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
