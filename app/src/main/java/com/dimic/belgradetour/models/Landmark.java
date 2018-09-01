package com.dimic.belgradetour.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Landmark implements Serializable{
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private double latitude, longitude;

    public Landmark(String id, String name, String description, String imageUrl, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static List<Landmark> getAllLandmarks(){
        List<Landmark> list = new ArrayList<>();
        list.add(new Landmark("1","Kalemegdan", "Lepo jedno mesto", "https://rs.n1info.com/Picture/113259/jpeg/bg.jpg", 0, 0));
        list.add(new Landmark("2", "City hall", "bezveze jedno mesto", "https://thumbs.dreamstime.com/b/belgrade-city-hall-25729652.jpg", 0, 0));
        list.add(new Landmark("3", " hall", "bezveze jedno mesto", "https://thumbs.dreamstime.com/b/belgrade-city-hall-25729652.jpg",0,0));
        list.add(new Landmark("4", "City ", "bezveze jedno mesto", "https://thumbs.dreamstime.com/b/belgrade-city-hall-25729652.jpg",0,0));
        list.add(new Landmark("5", "Noise hall", "bezveze jedno mesto", "https://thumbs.dreamstime.com/b/belgrade-city-hall-25729652.jpg",0,0));
        return list;
    }
}
