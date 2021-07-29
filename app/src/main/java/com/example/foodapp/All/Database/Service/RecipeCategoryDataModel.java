package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeCategoryDataModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    List<RecipeCategorySubDataModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RecipeCategorySubDataModel> getData() {
        return data;
    }

    public void setData(List<RecipeCategorySubDataModel> data) {
        this.data = data;
    }


}


