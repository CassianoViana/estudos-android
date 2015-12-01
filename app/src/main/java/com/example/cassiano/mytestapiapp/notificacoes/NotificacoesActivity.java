package com.example.cassiano.mytestapiapp.notificacoes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cassiano.mytestapiapp.PrimeiraActivity;
import com.example.cassiano.mytestapiapp.R;
import com.example.cassiano.mytestapiapp.broadcasts.BroadcastActivity;

/**
 * Created by Cassiano on 01/12/2015.
 */
public class NotificacoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    public void mostrar1(View view) {

        Notification.Builder builder = new Notification.Builder(this);

        builder.setContentTitle("Notificação")
                .setContentText("Olá! Você recebeu uma notificação!!")
                .setSmallIcon(android.R.drawable.sym_action_chat);

        Intent intent = new Intent(this, PrimeiraActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.setVisibility(Notification.VISIBILITY_PRIVATE);
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_ALL);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(R.string.notificacao1, n);
    }

    public void mostrar2(View view) {

        Notification.Builder builder = new Notification.Builder(this);

        Notification.BigTextStyle style = new Notification.BigTextStyle()
                .setBigContentTitle("Título")
                .bigText("Texto da mensagem");
        builder.setStyle(style);

        Intent intent1 = new Intent(this, MyBroadcastMsg.class);
        intent1.setAction(MyBroadcastMsg.ACTION_BUTTON_1);
        PendingIntent pi1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        Intent intent2 = new Intent(this, MyBroadcastMsg.class);
        intent2.setAction(MyBroadcastMsg.ACTION_BUTTON_2);
        PendingIntent pi2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        /*builder.addAction(android.R.drawable.ic_input_add, "Ação 1", pi1);
        builder.addAction(android.R.drawable.ic_delete, "Ação 2", pi2);*/

        builder.setAutoCancel(true);
        builder.setVisibility(Notification.VISIBILITY_PRIVATE);
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_ALL);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(R.string.notificacao2, n);

    }
}
