package com.dimic.belgradetour.models;

import com.dimic.belgradetour.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Landmark implements Serializable{
    private String id;
    private String name;
    private String description;
    private Integer image;
    private double latitude, longitude;

    public Landmark(String id, String name, String description, Integer image, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public static List<Landmark> getAllLandmarks(){
        List<Landmark> list = new ArrayList<>();
        list.add(new Landmark("1","Kalemegdan", "Lepo jedno mesto", R.drawable.kalemegdan , 44.816,20.4462384));
        list.add(new Landmark("2", "Monument to Prince Mihailo", "Na Trgu Republike", R.drawable.knez,44.8162589 , 20.4581312 ));
        list.add(new Landmark("3", "Terazije Fountain", "Fontana kod hotela Moskva", R.drawable.terazije,44.812817,20.458324));
        list.add(new Landmark("4", "National Assembly Building ", "Ovde se skuljaju svi politicari", R.drawable.narodna_skupstina,44.8117406, 20.4637728));
        list.add(new Landmark("5", "St. Sava's Cathedral", "Najlepsi pravoslavni hram na Balkanu", R.drawable.sv_sava,44.7980694,20.4669297));
        return list;
    }
}
