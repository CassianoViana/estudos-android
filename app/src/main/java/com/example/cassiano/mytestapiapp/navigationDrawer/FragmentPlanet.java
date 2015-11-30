package com.example.cassiano.mytestapiapp.navigationDrawer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cassiano.mytestapiapp.R;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class FragmentPlanet extends Fragment {

    private Planet planet;

    public static FragmentPlanet newInstance(Planet planet){
        FragmentPlanet fragment = new FragmentPlanet();
        fragment.planet = planet;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planet, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.planet_img);
        imageView.setImageResource(planet.getPlanetImg());
        getActivity().setTitle(planet.getPlanetName());

        return view;
    }
}
