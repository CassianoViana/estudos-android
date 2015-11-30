package com.example.cassiano.mytestapiapp.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class SpinnerActivity extends Activity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ArrayAdapter<Character> adapter;
    private Spinner spinLetras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        adapter = new ArrayAdapter<Character>(this, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add(new Character('A'));
        adapter.add(new Character('C'));
        adapter.add(new Character('D'));
        adapter.add(new Character('E'));

        spinLetras = (Spinner) findViewById(R.id.spinLetras);
        spinLetras.setAdapter(adapter);
        spinLetras.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Character c = adapter.getItem(position);
        Toast.makeText(this, "Letra clicada: " + c, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
