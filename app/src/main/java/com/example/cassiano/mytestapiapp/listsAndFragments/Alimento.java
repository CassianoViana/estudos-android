package com.example.cassiano.mytestapiapp.listsAndFragments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassiano on 25/11/2015.
 */
public class Alimento {

    private String nome;
    private Double preco;

    public Alimento(String nome, Double preco) {
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

    public static List<Alimento> listaAlimentos(){

        List<Alimento> products = new ArrayList<>();

        products.add(new Alimento("Café", 5.5));
        products.add(new Alimento("Batata", 9.5));
        products.add(new Alimento("Limão", 8.0));
        products.add(new Alimento("Feijão", 7.9));

        return products;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
