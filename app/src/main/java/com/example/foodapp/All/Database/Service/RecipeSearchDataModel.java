package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeSearchDataModel {

    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    RecipeSubDataModel data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RecipeSubDataModel getData() {
        return data;
    }

    public void setData(RecipeSubDataModel data) {
        this.data = data;
    }


}


