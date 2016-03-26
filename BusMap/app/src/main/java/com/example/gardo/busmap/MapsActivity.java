package com.example.gardo.busmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import android.location.Location;
import android.location.LocationManager;
import android.content.Context;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker[] placeMarkers;
    private final int MAX_PLACES = 20;
    private MarkerOptions[] places;
    private int userIcon, foodIcon, drinkIcon, shopIcon, otherIcon;
    private Marker userMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        userIcon = R.drawable.red_points;
//        foodIcon = R.drawable.red_point;
//        drinkIcon = R.drawable.blue_point;
//        shopIcon = R.drawable.green_point;
        otherIcon = R.drawable.bus;
        placeMarkers = new Marker[MAX_PLACES];
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        }
        mMap.setMyLocationEnabled(true);
    }

    protected void onPostExecute(String result) {
        if(placeMarkers!=null){
            for(int pm=0; pm<placeMarkers.length; pm++){
                if(placeMarkers[pm]!=null)
                    placeMarkers[pm].remove();
            }
        }
        try {
            JSONObject resultObject = new JSONObject(result);
            JSONArray placesArray = resultObject.getJSONArray("results");
            places = new MarkerOptions[placesArray.length()];
            for (int p=0; p<placesArray.length(); p++) {
                boolean missingValue=false;
                LatLng placeLL=null;
                String placeName="";
                String vicinity="";
                int currIcon = otherIcon;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
