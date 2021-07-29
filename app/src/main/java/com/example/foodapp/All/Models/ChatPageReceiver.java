package com.example.foodapp.All.Models;

public class ChatPageReceiver {

    String message,time;
    public ChatPageReceiver(String message, String time)
    {
        this.message = message;
        this.time = time;
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
