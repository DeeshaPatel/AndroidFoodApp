package com.example.foodapp.All.Models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class LoginUser {

    @SerializedName("Status")
            @Expose
            private String Status;
    @SerializedName("Data")
            @Expose
            private Token Data;
    @SerializedName("Message")
    @Expose
    private String Message;


    public LoginUser(String Username,Token Password,String message){
        this.Status= Username;
        this.Data = Password;
        this.Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Token getData() {
        return Data;
    }

    public void setData(Token data) {
        Data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public class Token {

        @SerializedName("Token")
        public String token;

        Token(String token)
        {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

}
