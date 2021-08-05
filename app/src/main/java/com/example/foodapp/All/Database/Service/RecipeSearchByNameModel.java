package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchByNameModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    List<RecipeSearchByNameSubModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RecipeSearchByNameSubModel> getData() {
        return data;
    }

    public void setData(List<RecipeSearchByNameSubModel> data) {
        this.data = data;
    }


}


