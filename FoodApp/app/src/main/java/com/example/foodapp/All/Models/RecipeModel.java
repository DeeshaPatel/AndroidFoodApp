package com.example.foodapp.All.Models;

public class RecipeModel {
    String name,cal;
    int id;
    public  RecipeModel(String name,String cal,int id)
    {
        this.name = name;
        this.cal = cal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }
}
