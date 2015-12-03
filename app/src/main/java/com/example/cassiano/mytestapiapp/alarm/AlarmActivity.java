package com.example.cassiano.mytestapiapp.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

import java.util.Calendar;

/**
 * Created by Cassiano on 03/12/2015.
 */
public class AlarmActivity extends AppCompatActivity {

    private PendingIntent pi;
    private AlarmManager alarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
    }


    public void agendar(View view) {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.SECOND, 5);

        Intent intent = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getBroadcast(this, 0, intent, 0);

        //alarm.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pi);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, 2000, c.getTimeInMillis(), pi);
    }

    public void cancelar(View view) {
        if (pi != null) {
            alarm.cancel(pi);
        }
    }
}
