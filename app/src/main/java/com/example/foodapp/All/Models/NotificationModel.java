package com.example.foodapp.All.Models;

public class NotificationModel {

    int id;
    String n_title,n_des,n_date;

    public  NotificationModel(int id, String n_title, String n_des, String n_date){
        this.id = id;
        this.n_title = n_title;
        this.n_des = n_des;
        this.n_date = n_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_date() {
        return n_date;
    }

    public void setN_date(String n_date) {
        this.n_date = n_date;
    }

    public String getN_des() {
        return n_des;
    }

    public void setN_des(String n_des) {
        this.n_des = n_des;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }
}
