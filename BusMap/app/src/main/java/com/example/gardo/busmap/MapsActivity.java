package com.example.gardo.busmap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,AdapterView.OnItemClickListener {

    protected GoogleMap mMap;
    protected String strSearch;
    protected EditText plainText;
    protected ListView listView;
    protected Button btnSearch;
    protected ArrayList<String> arrayList;
    protected ArrayAdapter<String>adapter;
    protected RelativeLayout relativeLayout;
    protected RelativeLayout relativeD_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait);

        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        relativeLayout = (RelativeLayout)findViewById(R.id.reLayout);

//        plainText = (EditText)findViewById(R.id.txtSearch);
        listView = (ListView)findViewById(R.id.listView);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        strSearch= plainText.getText().toString();
        arrayList = new ArrayList<>();
        arrayList.add("Hanh");
        arrayList.add("Tu");
        arrayList.add("Thuong");
        arrayList.add("Quan");
        arrayList.add("Hanh1");
        arrayList.add("Tu2");
        arrayList.add("Thuong3");
        arrayList.add("Quan4");
        adapter = new ArrayAdapter<String>(this,android.
                R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        setContentView(R.layout.detail_form);
    }
}
