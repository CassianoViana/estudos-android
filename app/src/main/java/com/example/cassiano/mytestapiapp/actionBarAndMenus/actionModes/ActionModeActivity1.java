package com.example.cassiano.mytestapiapp.actionBarAndMenus.actionModes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 27/11/2015.
 */
public class ActionModeActivity1 extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {

    private boolean actionModeStarted = false;
    private TextView txt_contador;
    private int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);
        txt_contador = (TextView) findViewById(R.id.txt_contador);
        txt_contador.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        if(!actionModeStarted) {
            startActionMode(this);
            actionModeStarted = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.actions1, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if(item.getItemId() == R.id.act_play){
            contador ++;
            txt_contador.setText(String.valueOf(contador));
            mode.finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionModeStarted = false;
    }
}
