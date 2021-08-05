package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

public class GetSliderImageDataModel {

    @SerializedName("ImageUrl")
    String ImageUrl;

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}
