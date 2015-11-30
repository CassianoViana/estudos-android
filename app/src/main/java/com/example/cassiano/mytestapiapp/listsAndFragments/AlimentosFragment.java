package com.example.cassiano.mytestapiapp.listsAndFragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class AlimentosFragment extends ListFragment {

    private ArrayAdapter<Alimento> adapter;
    private AlimentoClicadoListener listener;

    @Override
    public void onAttach(Activity context) {

        if (!(context instanceof AlimentoClicadoListener)) {
            throw new RuntimeException("O contexto deve implementar a interface AlimentosFragment.AlimentoClicadoListener");
        }
        listener = (AlimentoClicadoListener) context;
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);

        List<Alimento> alimentos = Alimento.listaAlimentos();
        for (Alimento alimento : alimentos) adapter.add(alimento);

        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.alimentoClicado(adapter.getItem(position));
        }
    }

    public interface AlimentoClicadoListener {
        void alimentoClicado(Alimento alimento);
    }
}
