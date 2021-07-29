package com.example.foodapp.All.Models;

import java.util.List;

public class FoodDiaryMealModel {

    String name,cal;
    int image;
    List<FoodDiaryMealSubItemModel> itemModels;

    public FoodDiaryMealModel(String name, String cal, int id,List<FoodDiaryMealSubItemModel> itemModels){
        this.name = name;
        this.cal = cal;
        this.image = id;
        this.itemModels = itemModels;
    }

    public List<FoodDiaryMealSubItemModel> getItemModels() {
        return itemModels;
    }

    public void setItemModels(List<FoodDiaryMealSubItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int id) {
        this.image = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
