package com.example.cassiano.mytestapiapp.listsAndFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class PrecoFragment extends Fragment {

    private TextView txtPreco;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preco, container, false);
        txtPreco = (TextView) view.findViewById(R.id.txt_preco);
        return view;
    }

    public void setPreco(String preco) {
        txtPreco.setText(preco);
    }
}
