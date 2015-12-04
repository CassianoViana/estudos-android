package com.example.cassiano.mytestapiapp.broadcasts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.alarm.AlarmReceiver;

public class PowerReceiver extends BroadcastReceiver {

    private AlarmManager alarmManager;
    private PendingIntent pendingIntentAlarm;

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = null;

        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            msg = "Dispositivo conectado";
            armaAlarme(context);

        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            msg = "Dispositivo desconectado";
            cancelaAlarme();
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    private void armaAlarme(Context context) {
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        pendingIntentAlarm = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, pendingIntentAlarm);
    }

    private void cancelaAlarme(){
        alarmManager.cancel(pendingIntentAlarm);
    }
}
