package com.example.cassiano.mytestapiapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 23/11/2015.
 */
public class FragmentContentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content_a, container, false);
    }
}
