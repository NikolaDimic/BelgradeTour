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
    private String info;
    private double latitude, longitude;

    public Landmark(String id, String name, String description, Integer image,String info, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.info=info;

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

    public String getInfo() {
        return info;
    }

    public void seInfo(String info) {
        this.info = info;
    }

    public static List<Landmark> getAllLandmarks(){
        List<Landmark> list = new ArrayList<>();
        list.add(new Landmark("1","The Victor", "Lepo jedno mesto", R.drawable.victor , "Kalemegdan Fortres,Belgrade," ,44.824993, 20.455659));
        list.add(new Landmark("2","Kalemegdan Fortress", "Lepo jedno mesto", R.drawable.kalemegdan , "The Victor,Belgrade" ,44.822994, 20.447800));
        list.add(new Landmark("3", "Monument to Prince Mihailo", "Na Trgu Republike", R.drawable.knez,"Republic Square, Trg republike, Belgrade," ,44.8161427,20.4604437 ));
        list.add(new Landmark("4", "Terazije Fountain", "Fontana kod hotela Moskva", R.drawable.terazije,"Hotel Moscow, Terazije, Belgrade," ,44.813410, 20.460742));
        list.add(new Landmark("5", "National Assembly Building ", "Ovde se skuljaju svi politicari", R.drawable.narodna_skupstina,"National Assembly of Serbia, Trg Nikole Pašića, Belgrade," ,44.811722,20.4654215));
        list.add(new Landmark("6", "St. Sava's Cathedral", "Najlepsi pravoslavni hram na Balkanu", R.drawable.sv_sava,"Sveti Sava Chtedral , Belgrade" ,44.798002,20.4679205));
        list.add(new Landmark("7", "Gardos Tower", "Kula u Zemunu", R.drawable.gardos,"The Millenium Tower, Stairs, Belgrade" ,44.847966,20.410107));
        list.add(new Landmark("8","Monument to Vuk Karadzic", "Lepo jedno mesto", R.drawable.vuk , "Bulevar kralja Aleksandra 106, Beograd" ,44.804819, 20.477323));
        list.add(new Landmark("9","Presidency Building", "Lepo jedno mesto", R.drawable.stari_dvor , "Presidency Building, Belgrade" ,44.809793, 20.463197));
        list.add(new Landmark("10","Ada Ciganlija", "Lepo jedno mesto", R.drawable.ada , "Ada Cignalija, Belgrade" ,44.790159, 20.414296));
        list.add(new Landmark("11","Knez Mihailova Street", "Lepo jedno mesto", R.drawable.knez_mihailova , "Kneza Mihaila, Beograd" ,44.817718, 20.457010));
        list.add(new Landmark("12","Ada Bridge Belgrade", "Lepo jedno mesto", R.drawable.most_ada , "Ada Bridge,Belgrade" ,44.796604, 20.426109));
        list.add(new Landmark("12","Belgrade Watherfront", "Lepo jedno mesto", R.drawable.savanova , "Belgrade Waterfront, Belgrade" ,44.809180, 20.449049));
        list.add(new Landmark("13","Tasmajdan Park", "Lepo jedno mesto", R.drawable.tas , "Tasmajdan Park,Belgrade" ,44.809054, 20.470825));
        list.add(new Landmark("14","Shool of Electrical Engineering", "Lepo jedno mesto", R.drawable.etf , "Elektrotehnicki Fakultet Beograd" ,44.805273, 20.476110));
        list.add(new Landmark("15","Skadarlija", "Lepo jedno mesto", R.drawable.skadarlija , "Skadarska Beograd" ,44.817959, 20.464455));
        list.add(new Landmark("16","The National Museum of Serbia", "Lepo jedno mesto", R.drawable.narodni_muzej , "The National Museum Belgrade" ,44.816575, 20.459965));
        list.add(new Landmark("17","Avala Tower", "Lepo jedno mesto", R.drawable.avala , "Avala Tower, Belgrade" ,44.695792, 20.514817));
        list.add(new Landmark("18","Nikola Tesla Museum", "Lepo jedno mesto", R.drawable.tesla , "Nikola Tesla Museum Belgrade  " ,44.805108, 20.470722));
        list.add(new Landmark("19","The Monument to Unknown Hero", "Lepo jedno mesto", R.drawable.spomenik , "Spomenik Neznanom junaku, Beli Potok  " ,44.689018, 20.516007));
        list.add(new Landmark("20","? Inn", "Lepo jedno mesto", R.drawable.znak , "Kafana Znak pitanja, Kralja Petra, Belgrade   " ,44.817761, 20.452380));
        return list;
    }
}
