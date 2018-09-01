package com.dimic.belgradetour;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dimic.belgradetour.models.Landmark;
import com.dimic.belgradetour.utils.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RouteManager {
    private SharedPreferences sharedPreferences;

    public RouteManager(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void addLandmark(String landmarkId){
        Set<String> previousLandmarks = sharedPreferences.getStringSet(Constants.LANDMARKS, new HashSet<String>());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        previousLandmarks.add(landmarkId);
        editor.putStringSet(Constants.LANDMARKS, previousLandmarks);
        editor.apply();
    }

    public void removeLandmark(String landmarkId){
        Set<String> previousLandmarks = sharedPreferences.getStringSet(Constants.LANDMARKS, new HashSet<String>());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        previousLandmarks.remove(landmarkId);
        editor.putStringSet(Constants.LANDMARKS, previousLandmarks);
        editor.apply();
    }

    public List<Landmark> getRouteLandmarks(){
        Set<String> savedLandmarks = sharedPreferences.getStringSet(Constants.LANDMARKS, new HashSet<String>());
        List<Landmark> allLandmarks = Landmark.getAllLandmarks();
        List<Landmark> results = new ArrayList<>();
        for (int i = 0; i < allLandmarks.size(); i++) {
            if(savedLandmarks.contains(allLandmarks.get(i).getId())){
                results.add(allLandmarks.get(i));
            }
        }
        return results;
    }
}
