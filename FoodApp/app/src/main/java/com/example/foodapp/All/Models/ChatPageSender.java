package com.example.foodapp.All.Models;

public class ChatPageSender {

    int id;
    String message,time;
    public ChatPageSender(int id,String message,String time)
    {
        this.id = id;
        this.message = message;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
