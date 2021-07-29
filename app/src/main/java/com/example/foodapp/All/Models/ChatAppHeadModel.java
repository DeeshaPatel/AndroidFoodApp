package com.example.foodapp.All.Models;

public class ChatAppHeadModel {

    int id,color;
    public ChatAppHeadModel(int id,int color)
    {
        this.id = id;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
