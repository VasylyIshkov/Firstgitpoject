package com.example.myapplication.classes;

public class Phone {
    private String namePhone;
    private String modelCPU;
    private String ram;

    //public Phone(String namePhone,String modelCPU,String ram,String url)
    public Phone(String namePhone, String modelCPU, String ram) {
        this.namePhone = namePhone;
        this.modelCPU = modelCPU;
        this.ram = ram;
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
