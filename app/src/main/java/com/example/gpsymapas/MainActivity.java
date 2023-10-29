package com.example.gpsymapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{
    EditText txtLatitud, txtLongitud;
    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        SupportMapFragment mFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mFrag.getMapAsync(this);
    }
    @Override
    public void onMapReady(@NonNull GoogleMap goMap){
        gMap = goMap;
        this.gMap.setOnMapClickListener(this);
        this.gMap.setOnMapLongClickListener(this);
        LatLng chile = new LatLng(-35.675147, -71.542969);
        gMap.addMarker(new MarkerOptions().position(chile).title("Chile"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(chile));
    }
    @Override
    public void onMapClick(@NonNull LatLng latlang){
        txtLongitud.setText(""+latlang.longitude);
        txtLatitud.setText(""+latlang.latitude);
    }
    @Override
    public void onMapLongClick(@NonNull LatLng latlang){
        txtLongitud.setText(""+latlang.longitude);
        txtLatitud.setText(""+latlang.latitude);
    }
}