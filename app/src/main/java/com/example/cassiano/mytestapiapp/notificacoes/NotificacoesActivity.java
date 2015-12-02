package com.example.cassiano.mytestapiapp.notificacoes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

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

        Intent intent1 = new Intent(this, MyBroadcastMsg.class);
        intent1.setAction(MyBroadcastMsg.ACTION_BUTTON_1);
        PendingIntent pi1 = PendingIntent.getBroadcast(this, 0, intent1, 0);

        Intent intent2 = new Intent(this, MyBroadcastMsg.class);
        intent2.setAction(MyBroadcastMsg.ACTION_BUTTON_2);
        PendingIntent pi2 = PendingIntent.getBroadcast(this, 0, intent2, 0);

        CharSequence msg = "Mensagem de notificação...";
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_alert)
                        .setContentTitle(getString(R.string.notification))
                        .setContentText(getString(R.string.ping))
                        .setDefaults(Notification.DEFAULT_ALL) // requires VIBRATE permission
        /*
         * Sets the big view "big text" style and supplies the
         * text (the user's reminder message) that will be displayed
         * in the detail area of the expanded notification.
         * These calls are ignored by the support library for
         * pre-4.1 devices.
         */
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .addAction(android.R.drawable.ic_menu_close_clear_cancel,
                                getString(R.string.dismiss), pi1)
                        .addAction(android.R.drawable.ic_lock_idle_lock,
                                getString(R.string.snooze), pi2);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(R.string.notificacao2, n);
    }

    public void downloadImage(View view) {

        //1 - Notification manager
        final int id = 1;
        final NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Download image")
                .setContentText("Download em progresso...")
                .setSmallIcon(android.R.drawable.ic_dialog_email);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 100; i++) {

                    // 2 - Progresso
                    builder.setProgress(100, i, false);
                    nm.notify(id, builder.build());

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 3 - Zera o progresso quando completar o download
                builder.setContentText("Download completo! Exemplo de barra indeterminada.").setProgress(0, 0, false);
                nm.notify(id, builder.build());

            }
        }).start();

    }
}
