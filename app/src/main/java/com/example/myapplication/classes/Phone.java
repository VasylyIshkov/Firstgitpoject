package com.example.myapplication.classes;

import android.widget.ImageView;

public class Phone {
    private String namePhone;
    private String modelCPU;
    private String ram;
    private ImageView imageView;

    //public Phone(String namePhone,String modelCPU,String ram,String url)
    public Phone(String namePhone, String modelCPU, String ram,ImageView imageView) {
        this.namePhone = namePhone;
        this.modelCPU = modelCPU;
        this.ram = ram;
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public String getRam() {
        return ram;
    }

    public String getModelCPU() {
        return modelCPU;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public String getInfo() {
        return "Phone - " + namePhone + "\nModel CPU - " + modelCPU + "\nRAM - " + ram + "\n";
    }

}
