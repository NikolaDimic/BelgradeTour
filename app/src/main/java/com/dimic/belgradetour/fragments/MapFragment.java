package com.dimic.belgradetour.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dimic.belgradetour.R;
import com.dimic.belgradetour.models.Landmark;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {


    private MapView mapView;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;



    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {
        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.getMapAsync(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng kamera = new LatLng(44.816, 20.4603);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(kamera)
                .zoom(13)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


        LatLng m1 = new LatLng(44.816, 20.4603);
        MarkerOptions options=new MarkerOptions()
                .position(m1)
                .snippet("Lepo jedno mesto")
                .title("Kalemegdan");
        mMap.addMarker(options);

        LatLng m2 = new LatLng(44.8162589 , 20.4581312);
        MarkerOptions options2=new MarkerOptions()
                .position(m2)
                .snippet("Na Trgu Republike")
                .title("Monument to Prince Mihailo");
        mMap.addMarker(options2);

        LatLng m3 = new LatLng(44.812817,20.458324);
        MarkerOptions options3=new MarkerOptions()
                .position(m3)
                .snippet("Fontana kod hotela Moskva")
                .title("Terazije Fountain");
        mMap.addMarker(options3);

        LatLng m4 = new LatLng(44.8117406, 20.4637728);
        MarkerOptions options4=new MarkerOptions()
                .position(m4)
                .snippet("Ovde se skuljaju svi politicari")
                .title("National Assembly");
        mMap.addMarker(options4);

        LatLng m5 = new LatLng(44.7980694,20.4669297);
        MarkerOptions options5=new MarkerOptions()
                .position(m5)
                .snippet("Najlepsi pravoslavni hram na Balkanu")
                .title("St. Sava's Cathedral");
        mMap.addMarker(options5);




    }

}
