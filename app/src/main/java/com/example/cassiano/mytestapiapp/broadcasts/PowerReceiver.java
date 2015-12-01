package com.example.cassiano.mytestapiapp.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = null;
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            msg = "Dispositivo conectado";
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            msg = "Dispositivo desconectado";
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
