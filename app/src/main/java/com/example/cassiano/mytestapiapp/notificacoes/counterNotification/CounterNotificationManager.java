package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 02/12/2015.
 */
public class CounterNotificationManager implements CounterListener {

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private Context context;
    private static OnNotificationInterationListener listener;
    private static final int id = 200;

    private static final String ACTION_CANCELAR = "CANCELAR";

    public CounterNotificationManager(Context context) {

        this.builder = new NotificationCompat.Builder(context);
        this.notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        this.context = context;
        try {
            listener = (OnNotificationInterationListener) context;
        } catch (ClassCastException c) {
            throw new ClassCastException(context.toString() + " must implement CounterNotificationManager.OnNotificationInterationListener");
        }
        cria();
    }

    private Notification cria() {

        String msg = context.getResources().getString(R.string.txt_notificacao_contador);

        Intent intent = new Intent(context, NotificationActionService.class)
                .setAction(ACTION_CANCELAR);

        PendingIntent pendingIntentCancel = PendingIntent.getService(context, 0, intent, 0);

        return builder
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setContentTitle(context.getResources().getString(R.string.contador_notification_title))
                .setContentText(msg)
                .addAction(android.R.drawable.ic_media_pause, context.getString(R.string.parar), pendingIntentCancel)
                .setContentIntent(pendingIntentCancel)
                .build();
    }

    @Override
    public void contagemIniciou(int max) {
        builder.setProgress(1000, 0, false)
                .setContentText(context.getString(R.string.msg_notificacao_contador_iniciado)).setProgress(max, 0, false);
        notificationManager.notify(id, builder.build());
    }

    @Override
    public void contagemAlterou(int passo) {
        builder.setProgress(1000, passo, false).setContentText("Contador: " + passo);
        notificationManager.notify(id, builder.build());
    }

    @Override
    public void contagemFinalizou(boolean cancelado) {
        builder.setContentText(context.getString(R.string.msg_notificacao_contador_finalizado)).setProgress(0, 0, false);
    }

    public interface OnNotificationInterationListener {
        void cancelar();
    }


    public static class NotificationActionService extends IntentService {

        public NotificationActionService() {
            super(NotificationActionService.class.getSimpleName());
        }

        @Override
        protected void onHandleIntent(Intent intent) {
            String action = intent.getAction();
            if (ACTION_CANCELAR.equals(action)) {
                Log.d("notificação", "Ouviu evento");
                listener.cancelar();
            }
        }
    }
}
