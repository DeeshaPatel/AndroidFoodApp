package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetBlogDataMainModel {
    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    ArrayList<GetBlogDataMainDataModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<GetBlogDataMainDataModel> getData() {
        return data;
    }

    public void setData(ArrayList<GetBlogDataMainDataModel> data) {
        this.data = data;
    }
}
