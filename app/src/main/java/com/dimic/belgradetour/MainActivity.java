package com.dimic.belgradetour;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dimic.belgradetour.fragments.MapFragment;
import com.dimic.belgradetour.fragments.SightListFragment;
import com.dimic.belgradetour.fragments.TourFragment;
import com.google.android.gms.location.FusedLocationProviderClient;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationProviderClient;

    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.map:
                    fragment = MapFragment.newInstance();
                    updateTitle("Map");
                    break;
                case R.id.tour:
                    updateTitle("My Route");
                    fragment = TourFragment.newInstance();
                    break;
                case R.id.sight_list:
                    updateTitle("All Landmarks");
                    fragment = SightListFragment.newInstance();
                    break;
            }
            switchToFragment(fragment);
            return true;
        }
    };

    private void switchToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)  
                .commit();
    }

    private void updateTitle(String title){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        switchToFragment(MapFragment.newInstance());
        updateTitle("Map");
    }

}
