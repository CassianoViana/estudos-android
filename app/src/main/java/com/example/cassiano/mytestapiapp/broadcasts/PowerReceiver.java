package com.example.cassiano.mytestapiapp.broadcasts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.alarm.AlarmReceiver;

public class PowerReceiver extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = null;

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntentAlarm = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            msg = "Dispositivo conectado";
            armaAlarme(context, pendingIntentAlarm, alarmManager);

        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            msg = "Dispositivo desconectado";
            cancelaAlarme(alarmManager,pendingIntentAlarm);
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    private void armaAlarme(Context context, PendingIntent intent, AlarmManager alarmManager) {
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, intent);
    }

    private void cancelaAlarme(AlarmManager alarmManager, PendingIntent intent){
        Log.d("TAG", "Cancelou");
        alarmManager.cancel(intent);
    }
}
