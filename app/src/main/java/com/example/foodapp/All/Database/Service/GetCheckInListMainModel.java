package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCheckInListMainModel {
    @SerializedName("Status")
    String status;

    @SerializedName("Data")
    List<GetCheckInListSubDataModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<GetCheckInListSubDataModel> getData() {
        return data;
    }

    public void setData(List<GetCheckInListSubDataModel> data) {
        this.data = data;
    }
}
