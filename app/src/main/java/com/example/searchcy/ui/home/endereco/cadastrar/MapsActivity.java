package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.searchcy.databinding.ActivityMapsBinding;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.example.searchcy.R;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private PlacesClient placesClient;
    //private LatLng latLng;
    private double lati, longi;
    private String endereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        endereco = intent.getStringExtra("endereco");

        Places.initialize(getApplicationContext(), "AIzaSyCxDQL9LOfMyylI8sws_uiqncjMEbqmais");
        placesClient = Places.createClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lati = Double.parseDouble(binding.edtLati.getText().toString());
                longi = Double.parseDouble(binding.edtLongi.getText().toString());
                mapFragment.getMapAsync(MapsActivity.this);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng latLng = new LatLng(lati, longi);
        mMap.addMarker(new MarkerOptions().position(latLng).title(endereco));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,
                15));
    }

    public void buscarEndereco(View view) {
        try {
            lati = Double.parseDouble(binding.edtLati.getText().toString());
            longi = Double.parseDouble(binding.edtLongi.getText().toString());
            Intent intent=new Intent(MapsActivity.this, CadastrarEnderecoFragment.class);
            Bundle bundle=new Bundle();
            bundle.putDouble("lati",lati);
            bundle.putDouble("longi",longi);
            intent.putExtra("bundle",bundle);
            startActivity(intent);
        }catch (Exception e) {
        }
    }
}