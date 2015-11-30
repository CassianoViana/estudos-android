package com.example.cassiano.mytestapiapp.communication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 24/11/2015.
 */
public class FragmentsCommunicationtActivity extends Activity implements InvertListener {

    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_fragments_communication);
    }

    @Override
    public void inverteu(String textoInvertido) {
        FragmentResult frag = (FragmentResult) getFragmentManager().findFragmentById(R.id.framentResult);
        frag.inverter(textoInvertido);
    }
}
