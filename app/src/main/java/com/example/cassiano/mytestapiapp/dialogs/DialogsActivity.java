package com.example.cassiano.mytestapiapp.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class DialogsActivity extends Activity implements ExitDialog.ExitListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    public void openSimpleDialog(View view) {
        SimpleDialog dialog = new SimpleDialog();
        dialog.show(getFragmentManager(), "simple");
    }

    public void openOptionsDialog(View view) {
        OptionsDialog dialog = new OptionsDialog();
        dialog.show(getFragmentManager(), "optionsDialog");
    }

    public void openRadioOptionsDialog(View view) {
        RadioOptionsDialog dialog = new RadioOptionsDialog();
        dialog.show(getFragmentManager(), "radioOptionsDialog");
    }

    public void openCheckOptionsDialog(View view) {
        CheckOptionsDialog dialog = new CheckOptionsDialog();
        dialog.show(getFragmentManager(), "checkOptionsDialog");
    }

    public void openCustomDialog(View view) {
        CustomDialog dialog = new CustomDialog();
        dialog.show(getFragmentManager(), "checkOptionsDialog");
    }

    public void openDateDialog(View view) {
        DataDialog dataDialog = new DataDialog();
        dataDialog.show(getFragmentManager(), "dataDialog");
    }

    public void openTimeDialog(View view) {
        TimeDialog timeDialog = new TimeDialog();
        timeDialog.show(getFragmentManager(), "timeDialog");
    }

    @Override
    public void onBackPressed() {
        ExitDialog dialog = new ExitDialog();
        dialog.show(getFragmentManager(), "exitDialog");
    }

    @Override
    public void onExit() {
        finish();
    }
}
