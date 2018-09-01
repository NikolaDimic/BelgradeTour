package com.dimic.belgradetour.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimic.belgradetour.LandmarksAdapter;
import com.dimic.belgradetour.R;
import com.dimic.belgradetour.models.Landmark;

/**
 * A simple {@link Fragment} subclass.
 */
public class SightListFragment extends Fragment {


    public SightListFragment() {
        // Required empty public constructor
    }

    public static SightListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SightListFragment fragment = new SightListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sight_list, container, false);
        RecyclerView landmarksRecyclerView = view.findViewById(R.id.landmarksRecyclerView);
        landmarksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LandmarksAdapter landmarksAdapter = new LandmarksAdapter(Landmark.getAllLandmarks(), getActivity());
        landmarksRecyclerView.setAdapter(landmarksAdapter);
        return view;
    }

}
