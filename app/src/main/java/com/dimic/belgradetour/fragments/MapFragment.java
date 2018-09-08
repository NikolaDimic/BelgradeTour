package com.dimic.belgradetour.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.dimic.belgradetour.R;
import com.dimic.belgradetour.RouteManager;
import com.dimic.belgradetour.models.Landmark;
//import com.google.android.gms.common.api.ApiException;
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
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.JsonObject;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.android.PolyUtil;
import com.google.maps.model.DirectionsResult;
//import com.google.maps.model.DirectionsRoute;
import com.google.maps.errors.ApiException;
import com.google.maps.model.TravelMode;



import org.joda.time.DateTime;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class MapFragment extends Fragment implements OnMapReadyCallback {


    public static final int REQUEST_CODE = 1;
    private MapView mapView;
    private Button navigateButton;
    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Location myLocation;
    private RouteManager routeManager;
    private List<Landmark> routeLandmarks;



    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance() {
        Bundle args = new Bundle();

        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private DirectionsResult getDirectionsDetails(String origin, String destination, TravelMode mode) {
        DateTime now = new DateTime();
        try {
            return DirectionsApi.newRequest(getGeoContext())
                    .mode(mode)
                    .origin(origin)
                    .destination(destination)
                    .departureTime(now)
                    .await();
        } catch (ApiException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = view.findViewById(R.id.mapView);
        navigateButton = view.findViewById(R.id.navigateButton);
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //openGoogleMaps();
                pokreni();

            }
        });
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

        routeManager = new RouteManager(getActivity());
        routeLandmarks = routeManager.getRouteLandmarks();

        for (Landmark landmark : routeLandmarks) {
            LatLng m1 = new LatLng(landmark.getLatitude(), landmark.getLongitude());
            MarkerOptions options = new MarkerOptions()
                    .position(m1)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.location))
                    .snippet(landmark.getDescription())
                    .title(landmark.getName());
            mMap.addMarker(options);

        }
        getDeviceLocation();
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        //   DirectionsResult result=getDirectionsDetails("Trg Republike,Belgrade","Hram svetog save, Belgrade",TravelMode.WALKING);
        //  if(result!=null) {
        //       addPolyline(result, googleMap);
        //   }

    }


    public void getDeviceLocation() {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE);
            return;
        }
        final Task location = mFusedLocationProviderClient.getLastLocation();
        location.addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if (task.isSuccessful()) {
                    myLocation = (Location) task.getResult();
                }
            }
        });
    }

    private void openGoogleMaps() {
        String startingAddress = myLocation.getLatitude() + "," + myLocation.getLongitude();
        String destinationAddress = startingAddress;
        String additionalStops = "";
        for (Landmark landmark : routeLandmarks) {
            additionalStops += "+to:" + landmark.getLatitude() + "," + landmark.getLongitude();
        }
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr=" + startingAddress + "&daddr=" + destinationAddress + additionalStops + "&mode=walking"));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getDeviceLocation();
            } else {
                Toast.makeText(getActivity(), "Permission denied to get your location", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void addPolyline(DirectionsResult results, GoogleMap mMap) {
        List<LatLng> decodedPath = PolyUtil.decode(results.routes[0].overviewPolyline.getEncodedPath());
        mMap.addPolyline(new PolylineOptions().addAll(decodedPath));
    }


    private GeoApiContext getGeoContext() {
        GeoApiContext geoApiContext = new GeoApiContext();
        return geoApiContext
                .setQueryRateLimit(3)
                .setApiKey(getString(R.string.google_maps_API_key))
                .setConnectTimeout(1, TimeUnit.SECONDS)
                .setReadTimeout(1, TimeUnit.SECONDS)
                .setWriteTimeout(1, TimeUnit.SECONDS);
    }

    private void pokreni() {

        for (int i = 0; i < routeLandmarks.size() - 1; i++) {
            if (i == 0) {
                Landmark landmark3 = routeLandmarks.get(i);
                String origin = "My Location";
                String destonation = landmark3.getInfo();
                DirectionsResult result = getDirectionsDetails(origin, destonation, TravelMode.WALKING);
                if (result != null) {
                    addPolyline(result, mMap);
                }
            }

                {
                    Landmark landmark = routeLandmarks.get(i);
                    Landmark landmark1 = routeLandmarks.get(i + 1);
                    if (i + 1 == routeLandmarks.size()) {
                        break;
                    } else {
                        String origin = landmark.getInfo();
                        String destonation = landmark1.getInfo();
                        DirectionsResult result = getDirectionsDetails(origin, destonation, TravelMode.WALKING);
                        if (result != null) {
                            addPolyline(result, mMap);
                        }
                    }

                }

        }

    }



}



