package com.example.cassiano.mytestapiapp.navigationDrawer;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.cassiano.mytestapiapp.R;

import java.io.Serializable;

/**
 * Created by Cassiano on 30/11/2015.
 */
public class NavigationDrawerActivity extends AppCompatActivity implements PlanetAdapter.OnPlanetClickedListener {

    private DrawerLayout drawer;
    private ListView planetsList;
    private Planet selected;
    private ActionBarDrawerToggle toggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawer = (DrawerLayout) findViewById(R.id.drawerPlanets);
        planetsList = (ListView) findViewById(R.id.list_planets);

        planetsList.setAdapter(new PlanetAdapter(this, this));

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        toggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                setTitle(R.string.titleChose);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if(selected != null){
                    setTitle(selected.getPlanetName());
                }else{
                    setTitle(R.string.app_name);
                }
                invalidateOptionsMenu();
            }
        };

        drawer.setDrawerListener(toggle);

        if(savedInstanceState == null) {
            selectPlanet(null);
        }else{
            selected = (Planet) savedInstanceState.getSerializable("planet");
            selectPlanet(selected);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("planet", selected);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions_drawer, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawer.isDrawerOpen(planetsList);
        MenuItem lupa = menu.findItem(R.id.action_search);
        lupa.setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        if(item.getItemId() == R.id.action_search){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "Planeta " + selected.getPlanetName());
            startActivity(intent);
            return true;
        }
        drawer.openDrawer(planetsList);

        return false;
    }


    @Override
    public void onPlanetClicked(Planet planet) {
        selectPlanet(planet);
    }

    private void selectPlanet(Planet planet) {

        if (planet != null) {
            selected = planet;
            Fragment fragment = FragmentPlanet.newInstance(planet);
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frameToPlanet, fragment);
            transaction.commit();
            setTitle(planet.getPlanetName());
        }

        drawer.closeDrawer(planetsList);
    }
}
