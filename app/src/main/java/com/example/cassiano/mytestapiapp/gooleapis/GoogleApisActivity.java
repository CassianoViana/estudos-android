package com.example.cassiano.mytestapiapp.gooleapis;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by Cassiano on 04/12/2015.
 */
public class GoogleApisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        verificaInstalacaoGooglePlayService();
    }

    private void verificaInstalacaoGooglePlayService() {

        int result = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(result == ConnectionResult.SUCCESS){
            Toast.makeText(this,"GooglePlayServices instalado!", Toast.LENGTH_SHORT).show();
        }else{
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(result, this, 0);
            dialog.show();
        }
    }
}
