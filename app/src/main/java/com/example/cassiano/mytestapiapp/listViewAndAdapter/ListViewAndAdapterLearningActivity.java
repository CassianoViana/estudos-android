package com.example.cassiano.mytestapiapp.listViewAndAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class ListViewAndAdapterLearningActivity extends ListActivity {

    private ProdutoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_learning_list_view_and_adapters);

        adapter = new ProdutoAdapter(this, Produto.listaProdutos());
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Produto item = (Produto) adapter.getItem(position);
        Toast.makeText(this, "Item clicado: "+item.getNome(), Toast.LENGTH_SHORT).show();
    }
}
