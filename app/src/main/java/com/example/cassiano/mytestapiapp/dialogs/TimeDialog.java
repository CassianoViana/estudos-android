package com.example.cassiano.mytestapiapp.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class TimeDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar cal = Calendar.getInstance();
        return new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(getActivity(), String.format("%02d:%02d", hourOfDay, minute), Toast.LENGTH_SHORT).show();
            }
        },cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
    }
}
