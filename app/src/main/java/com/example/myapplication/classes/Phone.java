package com.example.myapplication.classes;


public class Phone {
    private String namePhone;
    private String modelCPU;
    private String ram;
    private int idRes;

    public Phone(String namePhone, String modelCPU, String ram, int idRes) {
        this.namePhone = namePhone;
        this.modelCPU = modelCPU;
        this.ram = ram;
        this.idRes = idRes;
    }

    public int getIdRes() {
        return idRes;
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
