package com.example.cassiano.mytestapiapp.communication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 24/11/2015.
 */
public class FragmentResult extends Fragment {

    private TextView txtInverted;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        txtInverted = (TextView) view.findViewById(R.id.txtInverted);
        return view;
    }

    public void inverter(String textoInvertido) {
        txtInverted.setText(textoInvertido);
    }
}