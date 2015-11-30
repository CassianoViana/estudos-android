package com.example.cassiano.mytestapiapp.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class DataDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(getActivity(), String.format("%02d/%02d/%d", dayOfMonth, monthOfYear + 1, year),Toast.LENGTH_SHORT).show();
            }
        }, 2016, 4, 13);
    }
}
