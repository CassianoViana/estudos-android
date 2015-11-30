package com.example.cassiano.mytestapiapp.navigationDrawer;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.cassiano.mytestapiapp.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class Planet implements Serializable {

    private int planetImg;
    private String planetName;

    public int getPlanetImg() {
        return planetImg;
    }
    public void setPlanetImg(int planetImg) {
        this.planetImg = planetImg;
    }
    public String getPlanetName() {
        return planetName;
    }
    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public static List<Planet> getPlanets(Context context){

        List<Planet> planets = new ArrayList<Planet>();

        if(context != null){

            String planetNames[] = context.getResources().getStringArray(R.array.planets);
            TypedArray planetsImgs = context.getResources().obtainTypedArray(R.array.planets_imgs);

            for(int i = 0; i < planetNames.length; i++){
                Planet planet = new Planet();
                planet.setPlanetName(planetNames[i]);
                planet.setPlanetImg(planetsImgs.getResourceId(i, -1));
                planets.add(planet);
            }

            planetsImgs.recycle();
        }

        return planets;
    }
}
