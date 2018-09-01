package com.dimic.belgradetour.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Landmark implements Serializable{
    private String name;
    private String description;
    private String imageUrl;

    public Landmark(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
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
        list.add(new Landmark("Kalemegdan", "Lepo jedno mesto", "https://rs.n1info.com/Picture/113259/jpeg/bg.jpg"));
        list.add(new Landmark("City hall", "bezveze jedno mesto", "https://thumbs.dreamstime.com/b/belgrade-city-hall-25729652.jpg"));
        return list;
    }
}
