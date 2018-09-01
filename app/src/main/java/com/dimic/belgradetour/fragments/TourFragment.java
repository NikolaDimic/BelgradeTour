package com.dimic.belgradetour.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dimic.belgradetour.R;

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
        return inflater.inflate(R.layout.fragment_tour, container, false);
    }

}
