package com.example.foodapp.All.Models;

public class HomeRecyModel {

    String name,color;
    int ima;

    public HomeRecyModel(String name, String color, int ima) {
        this.name = name;
        this.color = color;
        this.ima = ima;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIma() {
        return ima;
    }

    public void setIma(int ima) {
        this.ima = ima;
    }
}
