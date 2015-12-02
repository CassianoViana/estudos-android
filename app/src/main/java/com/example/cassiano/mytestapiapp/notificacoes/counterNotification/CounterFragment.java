package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

public class CounterFragment extends Fragment implements CounterListener {

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private Button btnStart;
    private TextView txtCounter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        configuraBtns(view);
        configuraLabel(view);
        return view;
    }

    private void configuraBtns(View view) {
        btnStart = (Button) view.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.iniciaContagem();
            }
        });
    }

    private void configuraLabel(View view) {
        txtCounter = (TextView) view.findViewById(R.id.txtCounter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void contagemIniciou(int max) {
        txtCounter.setText("0");
        txtCounter.setVisibility(View.VISIBLE);
        btnStart.setVisibility(View.GONE);
    }

    @Override
    public void contagemAlterou(int passo) {
        txtCounter.setText(String.valueOf(passo+1));
    }

    @Override
    public void contagemFinalizou(boolean cancelado) {

    }

    public interface OnFragmentInteractionListener {
        void iniciaContagem();
    }
}
