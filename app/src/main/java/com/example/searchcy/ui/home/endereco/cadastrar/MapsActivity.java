package com.example.searchcy.ui.home.endereco.cadastrar;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private PlacesClient placesClient;
    private LatLng latLng;
    private String titulo = "Marker in Sydney";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize the SDK
        Places.initialize(getApplicationContext(), "AIzaSyCxDQL9LOfMyylI8sws_uiqncjMEbqmais");
        // Create a new PlacesClient instance
        placesClient = Places.createClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        binding.btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String endereco = binding.edtLati.getText().toString();
                buscarEndereco(endereco);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    private void buscarEndereco(String endereco) {
        List<Place.Field> placeFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG, Place.Field.ADDRESS);
        FetchPlaceRequest request = FetchPlaceRequest.builder(endereco, placeFields).build();

        placesClient.fetchPlace(request).addOnSuccessListener((response) -> {
            Place place = response.getPlace();
            latLng = place.getLatLng();
            titulo = place.getName();
            if (latLng != null) {
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(latLng).title(titulo));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                binding.edtLati.setText(String.valueOf(latLng.latitude));
                binding.edtLongi.setText(String.valueOf(latLng.longitude));
                //binding.edtTitulo.setText(titulo);
            }
        }).addOnFailureListener((exception) -> {
            exception.printStackTrace();
        });
    }
}