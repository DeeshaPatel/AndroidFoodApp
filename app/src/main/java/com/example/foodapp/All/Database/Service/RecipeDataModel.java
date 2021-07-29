package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeDataModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    List<RecipeSubDataModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RecipeSubDataModel> getData() {
        return data;
    }

    public void setData(List<RecipeSubDataModel> data) {
        this.data = data;
    }


}


