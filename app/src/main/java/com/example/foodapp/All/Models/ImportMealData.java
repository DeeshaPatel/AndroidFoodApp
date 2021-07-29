package com.example.foodapp.All.Models;

public class ImportMealData {

    int id;
    String meal,ing,cal,pro,carb,fat;

    public ImportMealData(int id,String meal,String ing,String cal, String pro,String carb,String fat){
        this.id = id;
        this.meal = meal;
        this.ing = ing;
        this.cal = cal;
        this.pro = pro;
        this.carb = carb;
        this.fat = fat;
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

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getPro() {
        return pro;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getCarb() {
        return carb;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getFat() {
        return fat;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getMeal() {
        return meal;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }
}
