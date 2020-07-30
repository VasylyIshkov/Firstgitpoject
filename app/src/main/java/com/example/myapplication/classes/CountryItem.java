package com.example.myapplication.classes;

import java.util.ArrayList;

public class CountryItem {
    //for RecyclerView
    private String name;
    private String region;
    //flag = url_flag
    private String flag;

    //for SecondFragment
    private String nativeName;
    private long population;
    private long area;
    private String capital;
    private ArrayList<String> languages;

    public CountryItem(String name, String region, String flag, String nativeName, long population, long area, String capital, ArrayList<String> languages) {
        this.name = name;
        this.region = region;
        this.flag = flag;
        this.nativeName = nativeName;
        this.population = population;
        this.area = area;
        this.capital = capital;
        this.languages = languages;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String getLanguageById(int id) {
        return languages.get(id);
    }

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

}
