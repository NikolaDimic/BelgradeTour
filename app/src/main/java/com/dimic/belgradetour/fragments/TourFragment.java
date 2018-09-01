package com.dimic.belgradetour.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimic.belgradetour.R;
import com.dimic.belgradetour.RouteManager;
import com.dimic.belgradetour.TourLandmarksAdapter;
import com.dimic.belgradetour.models.Landmark;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourFragment extends Fragment {


    public TourFragment() {
        // Required empty public constructor
    }

    public static TourFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TourFragment fragment = new TourFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tour, container, false);
        RecyclerView chosenLandmarksRecyclerView = view.findViewById(R.id.chosenLandmarksRecyclerView);
        chosenLandmarksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RouteManager routeManager = new RouteManager(getActivity());
        List<Landmark> landmarks = routeManager.getRouteLandmarks();
        TourLandmarksAdapter adapter = new TourLandmarksAdapter(landmarks, getActivity());
        chosenLandmarksRecyclerView.setAdapter(adapter);

        return view;
    }

}
