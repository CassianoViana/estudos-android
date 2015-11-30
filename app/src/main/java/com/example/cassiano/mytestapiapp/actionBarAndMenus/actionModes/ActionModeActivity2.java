package com.example.cassiano.mytestapiapp.actionBarAndMenus.actionModes;

import android.app.ListActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cassiano.mytestapiapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassiano on 27/11/2015.
 */
public class ActionModeActivity2 extends ListActivity implements AbsListView.MultiChoiceModeListener {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> selecteds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("A");
        adapter.add("B");
        adapter.add("C");
        adapter.add("D");
        setListAdapter(adapter);

        listView = getListView();
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(this);
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

        View view = listView.getChildAt(position);
        if (checked) {
            selecteds.add(adapter.getItem(position));
            view.setBackgroundColor(Color.parseColor("#99ff66"));
        } else {
            selecteds.remove(adapter.getItem(position));
            view.setBackgroundColor(Color.TRANSPARENT);
        }

    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.actions2, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        if (item.getItemId() == R.id.act_delete) {
            for (String s : selecteds)
                adapter.remove(s);

            mode.finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        selecteds.clear();
        limpaLista();
    }
    private void limpaLista(){

        int count = listView.getChildCount();
        for(int i = 0; i < count; i++){
            View view = listView.getChildAt(i);
            view.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}