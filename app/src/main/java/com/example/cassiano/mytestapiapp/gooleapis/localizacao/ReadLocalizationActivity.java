package com.example.cassiano.mytestapiapp.gooleapis.localizacao;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cassiano.mytestapiapp.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

/**
 * Created by Cassiano on 04/12/2015.
 */
public class ReadLocalizationActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {


    private TextView txtLatitude;
    private TextView txtLongitude;

    private GoogleApiClient gapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao1);

        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);
        instanciaGoogleApiClient();
    }

    private void instanciaGoogleApiClient() {
        gapi =
                new GoogleApiClient.Builder(this)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        gapi.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        LocationServices.FusedLocationApi.removeLocationUpdates(gapi, this);
        gapi.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        /*
        Location location = LocationServices.FusedLocationApi.getLastLocation(gapi);
        if(location != null){
            txtLatitude.setText(String.valueOf(location.getLatitude()));
            txtLongitude.setText(String.valueOf(location.getLongitude()));
        }
        Intent intent = new Intent();
        */

        Toast.makeText(this, "Location connected", Toast.LENGTH_SHORT).show();

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(2000);
        locationRequest.setFastestInterval(1000);
        LocationServices.FusedLocationApi.requestLocationUpdates(gapi, locationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Connection suspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Connection failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "Location changed", Toast.LENGTH_SHORT).show();
        txtLatitude.setText(String.valueOf(location.getLatitude()));
        txtLongitude.setText(String.valueOf(location.getLongitude()));
    }
}
