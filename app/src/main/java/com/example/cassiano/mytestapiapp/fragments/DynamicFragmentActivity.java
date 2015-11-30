package com.example.cassiano.mytestapiapp.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 23/11/2015.
 */
public class DynamicFragmentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_dynamic_fragment);

        FragmentContentA fragA = new FragmentContentA();
        FragmentContentB fragB = new FragmentContentB();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_a, fragA, "fragA");
        ft.add(R.id.fragment_b, fragB, "fragB");
        ft.commit();

    }
}
