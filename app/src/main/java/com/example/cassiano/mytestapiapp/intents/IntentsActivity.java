package com.example.cassiano.mytestapiapp.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.cassiano.mytestapiapp.PrimeiraActivity;
import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 01/12/2015.
 */
public class IntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents1);
    }

    public void lancarIntent(View view) {

        // Intent intent = new Intent(this,PrimeiraActivity.class);
        // startActivity(intent);
        Intent intent = new Intent("com.example.cassiano.mytestapiapp.intent.action.TESTE");
        startActivity(intent);
    }

    public void configuracoes(View view) {
        // Intent intent = new Intent(this,PrimeiraActivity.class);
        // startActivity(intent);
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }

    public void openBrowser(View view) {
        Uri uri = Uri.parse("http://www.google.com.br");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
