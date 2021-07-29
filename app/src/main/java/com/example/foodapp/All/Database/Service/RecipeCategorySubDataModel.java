package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

public class RecipeCategorySubDataModel {

    @SerializedName("Name")
    String Name;

    @SerializedName("Id")
    String Id;

    @SerializedName("CategoryImage")
    String CategoryImage;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCategoryImage() {
        return CategoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        CategoryImage = categoryImage;
    }
}
