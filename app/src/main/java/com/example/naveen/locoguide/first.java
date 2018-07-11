package com.example.naveen.locoguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class first extends Fragment implements OnMapReadyCallback {
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    public first() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) mView.findViewById(R.id.map);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_third, container, false);
        return mView;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap=googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.addMarker(new MarkerOptions().position(new LatLng(10.416957, 77.900612)).title("Statue of liberty").snippet("i hope to go there"));
        CameraPosition liberty=CameraPosition.builder().target(new LatLng(10.416957, 77.900606)).zoom(16).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));

    }



}
