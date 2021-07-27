package com.example.foodapp.All.Models;

public class PickYourPlanModel {

    String cat,cal,pro,fat,carb;

    public PickYourPlanModel(String cat, String cal, String pro, String fat, String carb){
        this.cat = cat;
        this.cal = cal;
        this.pro = pro;
        this.fat = fat;
        this.carb = carb;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }
}
