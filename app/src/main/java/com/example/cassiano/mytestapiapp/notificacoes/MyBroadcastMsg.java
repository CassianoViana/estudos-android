package com.example.cassiano.mytestapiapp.notificacoes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastMsg extends BroadcastReceiver {

    public static final String ACTION_BUTTON_1 = "com.example.cassiano.mytesteapiapp.ACTION_BUTTON_1";
    public static final String ACTION_BUTTON_2 = "com.example.cassiano.mytesteapiapp.ACTION_BUTTON_2";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action =intent.getAction();
        String msg = "";
        if(action.equals(ACTION_BUTTON_1)){
            msg = "Botão 1 clicado";
        }else if(action.equals(ACTION_BUTTON_2)){
            msg = "Botão 2 clicado";
        }else{
            msg = "Ação desconhecida";
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

    }
}
