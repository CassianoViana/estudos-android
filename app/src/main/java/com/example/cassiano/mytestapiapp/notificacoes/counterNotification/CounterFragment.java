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


    private interface Tela {
        int getVisibilidadeBtn();

        int getVisibilidadeText();
    }

    private enum EstadoTela implements Tela {
        RODANDO {
            @Override
            public int getVisibilidadeBtn() {
                return View.GONE;
            }

            @Override
            public int getVisibilidadeText() {
                return View.VISIBLE;
            }
        },
        PAUSADO {
            @Override
            public int getVisibilidadeBtn() {
                return View.VISIBLE;
            }

            @Override
            public int getVisibilidadeText() {
                return View.GONE;
            }
        }
    }

    @SuppressWarnings("ResourceType")
    private void setEstadoTela(EstadoTela estadoTela) {
        btnStart.setVisibility(estadoTela.getVisibilidadeBtn());
        txtCounter.setVisibility(estadoTela.getVisibilidadeText());
    }

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("estado", "rodando");
    }

    private Button btnStart;
    private TextView txtCounter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        configuraBtns(view);
        configuraLabel(view);

        setEstadoTela(EstadoTela.PAUSADO);

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
        setEstadoTela(EstadoTela.RODANDO);
    }

    @Override
    public void contagemAlterou(int passo) {
        txtCounter.setText(String.valueOf(passo + 1));
    }

    @Override
    public void contagemFinalizou(boolean cancelado) {
        if(cancelado) {
            txtCounter.setText("Cancelado");
        }
        setEstadoTela(EstadoTela.PAUSADO);
    }

    public interface OnFragmentInteractionListener {
        void iniciaContagem();
    }
}
