package com.example.foodapp.All.Models;

public class ShoppingListModel {

    String meal, i1,i2,i3,i4,time;
    int photo;

    public ShoppingListModel(int photo, String meal, String i1, String i2, String i3,String i4, String time){
        this.photo = photo;
        this.meal = meal;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.time = time;
    }

    public String getMeal() {
        return meal;
    }

    public void setI1(String i1) {
        this.i1 = i1;
    }

    public int getPhoto() {
        return photo;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public String getI1() {
        return i1;
    }

    public void setI3(String i3) {
        this.i3 = i3;
    }

    public String getI2() {
        return i2;
    }

    public void setI4(String i4) {
        this.i4 = i4;
    }

    public String getI3() {
        return i3;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getI4() {
        return i4;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
