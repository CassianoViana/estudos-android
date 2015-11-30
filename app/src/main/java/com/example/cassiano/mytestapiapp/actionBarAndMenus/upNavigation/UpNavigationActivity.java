package com.example.cassiano.mytestapiapp.actionBarAndMenus.upNavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 27/11/2015.
 */
public class UpNavigationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_navigation_a);
    }

    public void irParaProximaActivity(View view) {
        Intent intent = new Intent(this, ProximaActivity.class);
        startActivity(intent);
    }
}
