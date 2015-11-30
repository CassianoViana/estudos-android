package com.example.cassiano.mytestapiapp.listViewAndAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public static List<Produto> listaProdutos(){

        List<Produto> products = new ArrayList<>();

        products.add(new Produto("Café", 5.5));
        products.add(new Produto("Batata", 9.5));
        products.add(new Produto("Limão", 8.0));
        products.add(new Produto("Feijão", 7.9));

        return products;
    }
}
