package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.cassiano.mytestapiapp.R;
import com.example.cassiano.mytestapiapp.notificacoes.MyBroadcastMsg;

/**
 * Created by Cassiano on 02/12/2015.
 */
public class CounterNotificationManager implements CounterListener {

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private Context context;
    private static final int id = 200;

    public CounterNotificationManager(Context context) {
        this.builder = new NotificationCompat.Builder(context);
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.context = context;
        cria();
    }

    private Notification cria() {

        String msg = context.getResources().getString(R.string.txt_notificacao_contador);

        Intent intent = new Intent(context, MyBroadcastMsg.class);
        intent.setAction(MyBroadcastMsg.ACTION_CANCELAR_CONTADOR);
        PendingIntent pendingIntentCancel = PendingIntent.getBroadcast(context, 0, intent, 0);

        return builder
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle(context.getResources().getString(R.string.contador_notification_title))
                .setContentText(msg)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel,
                        context.getString(R.string.dismiss), pendingIntentCancel)
                .setContentIntent(pendingIntentCancel)
                .build();
    }

    @Override
    public void contagemIniciou(int max) {
        builder.setProgress(100, 0, false)
                .setContentText(context.getString(R.string.msg_notificacao_contador_iniciado)).setProgress(max, 0, false);
    }

    @Override
    public void contagemAlterou(int passo) {
        builder.setProgress(100, passo, false).setContentText("Contador: " + passo);
        notificationManager.notify(id, builder.build());
    }

    @Override
    public void contagemFinalizou(boolean cancelado) {
        builder.setContentText(context.getString(R.string.msg_notificacao_contador_finalizado)).setProgress(0, 0, false);
        notificationManager.notify(id, builder.build());
    }
}
