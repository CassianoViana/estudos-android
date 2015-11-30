package com.example.cassiano.mytestapiapp.communication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 24/11/2015.
 */
public class FragmentText extends Fragment implements View.OnClickListener {

    private InvertListener listener;
    private Button button;
    private EditText editTextOriginal;

    @Override
    public void onAttach(Activity context) {
        if (!(context instanceof InvertListener)) {
            throw new RuntimeException("O contexto deve inplementar InvertListener!");
        }
        listener = (InvertListener) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text, container, false);

        button = (Button) view.findViewById(R.id.btnInverter);
        editTextOriginal = (EditText) view.findViewById(R.id.editTextOriginal);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Log.d("click", "Clicou!");
        if (listener != null) {
            String texto = editTextOriginal.getText().toString();
            listener.inverteu(new StringBuilder(texto).reverse().toString());
        }
    }
}
