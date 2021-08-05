package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetSliderImageMainModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    ArrayList<GetSliderImageDataModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<GetSliderImageDataModel> getData() {
        return data;
    }

    public void setData(ArrayList<GetSliderImageDataModel> data) {
        this.data = data;
    }

}
