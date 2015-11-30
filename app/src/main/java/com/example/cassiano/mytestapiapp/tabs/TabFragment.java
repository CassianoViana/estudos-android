package com.example.cassiano.mytestapiapp.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class TabFragment extends Fragment {

    private int posicao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int layoutRes = 0;

        if (posicao == 0) {
            layoutRes = R.layout.fragment1;
        } else if (posicao == 1) {
            layoutRes = R.layout.fragment2;
        } else if (posicao == 2) {
            layoutRes = R.layout.fragment3;
        }

        return inflater.inflate(layoutRes, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            posicao = (int) savedInstanceState.getSerializable("posicao");
        }
    }

    public static TabFragment newInstance(int posicao) {
        TabFragment tabFragment = new TabFragment();
        tabFragment.posicao = posicao;
        return tabFragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable("posicao", posicao);
    }
}
