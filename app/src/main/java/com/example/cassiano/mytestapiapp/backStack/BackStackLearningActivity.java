package com.example.cassiano.mytestapiapp.backStack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 24/11/2015.
 */
public class BackStackLearningActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_backstack);

        Fragment f1 = new Fragment1();
        Fragment f2 = new Fragment2();
        Fragment f3 = new Fragment3();

        FragmentManager fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame1, f1, "f1");
        ft.addToBackStack(null);
        ft.commit();

        ft = fm.beginTransaction();
        ft.add(R.id.frame2, f2, "f2");
        ft.addToBackStack(null);
        ft.commit();

        ft = fm.beginTransaction();
        ft.add(R.id.frame3, f3, "f3");
        ft.addToBackStack(null);
        ft.commit();
    }
}
