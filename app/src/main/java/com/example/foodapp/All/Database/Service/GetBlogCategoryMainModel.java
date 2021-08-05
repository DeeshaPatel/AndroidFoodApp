package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetBlogCategoryMainModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    ArrayList<GetBlogCategoryDataMode> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<GetBlogCategoryDataMode> getData() {
        return data;
    }

    public void setData(ArrayList<GetBlogCategoryDataMode> data) {
        this.data = data;
    }


}


