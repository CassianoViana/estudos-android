package com.example.cassiano.mytestapiapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Cassiano on 19/11/2015.
 */
public class SegundaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String mensagemPrimeira = getIntent().getStringExtra("msg1");

        TextView tview = (TextView) findViewById(R.id.campo_texto);
        tview.setText(mensagemPrimeira);
    }

    public void previous(View view) {

        Intent intent = new Intent(this, PrimeiraActivity.class);

        intent.putExtra("msgRetorno", "Mensagem da segunda activity");

        setResult(RESULT_OK, intent);
        finish();

    }
}
