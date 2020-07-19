package com.example.myapplication.classes;

import com.example.myapplication.R;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class Phone {
    private String namePhone;
    private String modelCPU;
    private String ram;
    //  private Image icon;

    //public Phone(String namePhone,String modelCPU,String ram,String url)
    public Phone(String namePhone, String modelCPU, String ram) {
        this.namePhone = namePhone;
        this.modelCPU = modelCPU;
        this.ram = ram;
        //this.icon = loadImage(url);
    }

    //    public Image getIcon() {
    //        return icon;
    //    }

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

//    public Image loadImage(String url)
//    {
//        try {
//            BufferedImage img = ImageIO.read(new URL(url));
//            return img;
//        }
//        catch (Exception ex)
//        {
//
//        }
//        Image img = new ImageIO.read("src/nokia_3310.png");
//    }
}
