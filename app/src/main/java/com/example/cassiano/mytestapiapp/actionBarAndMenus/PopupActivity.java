package com.example.cassiano.mytestapiapp.actionBarAndMenus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class PopupActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
    }

    public void showPopup(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.popup1:
                Toast.makeText(this, "Popup1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popup2:
                Toast.makeText(this, "Popup2", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}