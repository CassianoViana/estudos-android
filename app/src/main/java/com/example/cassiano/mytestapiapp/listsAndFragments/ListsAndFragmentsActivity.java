package com.example.cassiano.mytestapiapp.listsAndFragments;

import android.app.Activity;
import android.os.Bundle;

import com.example.cassiano.mytestapiapp.R;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class ListsAndFragmentsActivity extends Activity implements AlimentosFragment.AlimentoClicadoListener{

    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private PrecoFragment precoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_lists_and_fragments);
        precoFragment = (PrecoFragment) getFragmentManager().findFragmentById(R.id.frag_preco);
    }

    @Override
    public void alimentoClicado(Alimento alimento) {
        String preco = String.format("O preço do alimento %s é %s", alimento.getNome(), nf.format(alimento.getPreco()));
        precoFragment.setPreco(preco);
    }
}
