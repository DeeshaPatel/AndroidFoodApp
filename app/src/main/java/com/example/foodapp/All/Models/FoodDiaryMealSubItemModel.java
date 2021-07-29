package com.example.foodapp.All.Models;

public class FoodDiaryMealSubItemModel {

    String food_name,carb,fat,protain,cal;

    public FoodDiaryMealSubItemModel(String food_name, String carb, String fat, String protain, String cal)
    {
        this.food_name = food_name;
        this.carb = carb;
        this.fat = fat;
        this.protain = protain;
        this.cal = cal;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getProtain() {
        return protain;
    }

    public void setProtain(String protain) {
        this.protain = protain;
    }

}

