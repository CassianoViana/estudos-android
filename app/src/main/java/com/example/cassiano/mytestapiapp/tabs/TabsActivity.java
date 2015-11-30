package com.example.cassiano.mytestapiapp.tabs;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class TabsActivity extends FragmentActivity {

    ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        pager = (ViewPager) findViewById(R.id.tabsPager);
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        if (savedInstanceState != null) {
            int tab = savedInstanceState.getInt("tab");
            pager.setCurrentItem(tab);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("tab", pager.getCurrentItem());
    }
}
