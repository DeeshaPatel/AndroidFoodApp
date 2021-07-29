package com.example.foodapp.All.Models;

public class LibraryFoodModel {

    String name,gram,cal;
    public LibraryFoodModel(String name,String gram,String cal){
        this.name = name;
        this.gram = gram;
        this.cal = cal;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getGram() {
        return gram;
    }

    public void setGram(String gram) {
        this.gram = gram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
