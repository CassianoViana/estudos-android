package com.example.cassiano.mytestapiapp.notificacoes;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastMsg extends BroadcastReceiver {

    public static final String ACTION_BUTTON_1 = "com.example.cassiano.mytesteapiapp.ACTION_BUTTON_1";
    public static final String ACTION_BUTTON_2 = "com.example.cassiano.mytesteapiapp.ACTION_BUTTON_2";
    public static final String ACTION_CANCELAR_CONTADOR = "com.example.cassiano.mytesteapiapp.ACTION_CANCELAR_CONTADOR";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        switch (action) {
            case ACTION_BUTTON_1:
                metodo1(context);
                break;
            case ACTION_BUTTON_2:
                metodo2(context);
                break;
            case ACTION_CANCELAR_CONTADOR:
                metodo3(context);
        }
    }

    private void metodo3(Context context) {
    }

    private void metodo1(Context context) {
        Toast.makeText(context, "Botao 1 clicado", Toast.LENGTH_SHORT).show();
    }

    private void metodo2(Context context) {
        Toast.makeText(context, "Botao 2 clicado", Toast.LENGTH_SHORT).show();
    }
}
