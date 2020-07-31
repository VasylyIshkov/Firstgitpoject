package com.example.myapplication.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryItem {
    //for RecyclerView
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("region")
    @Expose
    private String region;
    //flag = url_flag
    @SerializedName("flag")
    @Expose
    private String flag;

    //for SecondFragment
    @SerializedName("nativeName")
    @Expose
    private String nativeName;
    @SerializedName("population")
    @Expose
    private long population;
    @SerializedName("area")
    @Expose
    private long area;
    @SerializedName("capital")
    @Expose
    private String capital;
    //private ArrayList<String> languages;

    public CountryItem(String name, String region, String flag, String nativeName, long population, long area, String capital) {
        this.name = name;
        this.region = region;
        this.flag = flag;
        this.nativeName = nativeName;
        this.population = population;
        this.area = area;
        this.capital = capital;
        //  this.languages = languages;
    }

//    public ArrayList<String> getLanguages() {
//        return languages;
//    }

//    public String getLanguageById(int id) {
//        return languages.get(id);
//    }

    public long getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }

    public String getCapital() {
        return capital;
    }

    public String getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getRegion() {
        return region;
    }

    public String getInfo() {
//        StringBuilder lang = new StringBuilder();
//        for (int i = 0; i < languages.size(); i++) {
//            lang.append(languages.get(i).toString()).append("\n");
//        }
        String info = "Название на родном языке - " + nativeName + "\n"
                + "Регион - " + getRegion() + "\n"
                + "Население - " + getPopulation() + "\n"
                + "Площадь - " + getArea() + "\n"
                + "Столица - " + getCapital(); //+ "\n"
        // + "Языки - " + lang;
        return info;
    }


}
