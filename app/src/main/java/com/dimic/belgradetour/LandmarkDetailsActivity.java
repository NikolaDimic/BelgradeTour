package com.dimic.belgradetour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dimic.belgradetour.models.Landmark;
import com.dimic.belgradetour.utils.Constants;

public class LandmarkDetailsActivity extends AppCompatActivity {

    public static void start(Context context, Landmark landmark) {
        Intent starter = new Intent(context, LandmarkDetailsActivity.class);
        starter.putExtra(Constants.LANDMARK, landmark);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landmark_details);
        Landmark landmark = (Landmark) getIntent().getSerializableExtra(Constants.LANDMARK);
        Toast.makeText(this, landmark.getName(), Toast.LENGTH_SHORT).show();


        TextView nameDetailsView = (TextView) findViewById(R.id.detailNameView);
        TextView textDetailsView = (TextView) findViewById(R.id.detailTextView);
        ImageView imageView = (ImageView) findViewById(R.id.detailImageView);


        nameDetailsView.setText(landmark.getName());
        textDetailsView.setText(landmark.getDescription());
        imageView.setImageResource(landmark.getImage());

    }
}
