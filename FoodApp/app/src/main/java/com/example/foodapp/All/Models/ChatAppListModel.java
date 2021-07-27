package com.example.foodapp.All.Models;

public class ChatAppListModel {

    int id,background;
    String name,lastMessage,time;

    public ChatAppListModel(int id,int background,String name,String lastMessage, String time)
    {
        this.id = id;
        this.background = background;
        this.name = name;
        this.lastMessage = lastMessage;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
