package com.example.cassiano.mytestapiapp.listViewAndAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cassiano.mytestapiapp.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class ProdutoAdapter extends BaseAdapter {

    private List<Produto> produtos;
    private LayoutInflater inflater;
    private static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));;
    public ProdutoAdapter(Context context, List<Produto> produtos) {
        this.produtos = produtos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder vh;

        if(view == null){
            view = inflater.inflate(R.layout.item_product_list, parent, false);
            vh = new ViewHolder();
            vh.txt_nome = (TextView) view.findViewById(R.id.txt_nome);
            vh.txt_preco = (TextView) view.findViewById(R.id.txt_preco);
            view.setTag(vh);
        }else{
            vh = (ViewHolder) view.getTag();
        }

        Produto produto = produtos.get(position);

        vh.txt_nome.setText(produto.getNome());
        vh.txt_preco.setText(nf.format(produto.getPreco()));

        return view;
    }

    private static class ViewHolder{
        TextView txt_nome;
        TextView txt_preco;
    }
}
