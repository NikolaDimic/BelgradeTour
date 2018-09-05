package com.dimic.belgradetour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimic.belgradetour.models.Landmark;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LandmarksAdapter extends RecyclerView.Adapter<LandmarksAdapter.LandmarkViewHolder> {

    private List<Landmark> landmarks;
    private Context context;

    public LandmarksAdapter(List<Landmark> landmarks, Context context) {
        this.landmarks = landmarks;
        this.context = context;
    }

    @NonNull
    @Override
    public LandmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.landmark_entry, parent, false);
        return new LandmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkViewHolder holder, int position) {
        holder.bind(landmarks.get(position));
    }

    @Override
    public int getItemCount() {
        return landmarks.size();
    }

    public class LandmarkViewHolder extends RecyclerView.ViewHolder {

        private ImageView landmarkImageView;
        private TextView nameTextView;
        private ConstraintLayout landmarkContainer;
        private ImageButton addButton;

        public LandmarkViewHolder(View itemView) {
            super(itemView);
            landmarkImageView = itemView.findViewById(R.id.landmarkImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            landmarkContainer = itemView.findViewById(R.id.landmarkContainer);
            addButton = itemView.findViewById(R.id.addButton);
        }

        public void bind(final Landmark landmark) {
            nameTextView.setText(landmark.getName());
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addLandmarkToRoute(landmark);
                }
            });
            Picasso.get().load(landmark.getImage()).into(landmarkImageView);
            landmarkContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LandmarkDetailsActivity.start(context, landmark);
                }
            });
        }
    }

    private void addLandmarkToRoute(Landmark landmark) {
        RouteManager routeManager = new RouteManager(context);
        routeManager.addLandmark(landmark.getId());
    }
}
