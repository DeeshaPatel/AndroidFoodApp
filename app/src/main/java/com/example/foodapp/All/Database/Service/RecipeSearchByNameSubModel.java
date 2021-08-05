package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

public class RecipeSearchByNameSubModel {

    @SerializedName("Id")
    String id;

    @SerializedName("RecipeName")
    String RecipeName;

    @SerializedName("Notes")
    String Notes;

    @SerializedName("ImagePath")
    String ImagePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
