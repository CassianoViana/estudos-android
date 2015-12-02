package com.example.cassiano.mytestapiapp.notificacoes.counterNotification;

/**
 * Created by Cassiano on 02/12/2015.
 */
public interface CounterListener {

    void contagemIniciou(int max);
    void contagemAlterou(int passo);
    void contagemFinalizou(boolean cancelado);

}
