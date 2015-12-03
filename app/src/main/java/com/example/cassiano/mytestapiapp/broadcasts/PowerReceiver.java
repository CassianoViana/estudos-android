package com.example.cassiano.mytestapiapp.broadcasts;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.alarm.AlarmReceiver;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = null;
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            msg = "Dispositivo conectado";
        }else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            msg = "Dispositivo desconectado";

            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 2000, pi);

        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
