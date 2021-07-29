package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecipeSubDataModel {

    @SerializedName("RecipeName")
    String RecipeName;

    @SerializedName("ImagePath")
    String ImagePath;

    @SerializedName("Notes")
    String notes;

    @SerializedName("Procedure")
    String Procedure;

    @SerializedName("TotalCarb")
    String TotalCarb;

    @SerializedName("TotalFat")
    String TotalFat;

    @SerializedName("TotalFiber")
    String TotalFiber;

    @SerializedName("TotalProtein")
    String TotalProtein;

    @SerializedName("Ingredients")
    ArrayList<RecipeDataDescriptionModel> Ingredient;

    public String getRecipeName() {
        return RecipeName;
    }

    public void setRecipeName(String recipeName) {
        RecipeName = recipeName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTotalCarb() {
        return TotalCarb;
    }

    public void setTotalCarb(String totalCarb) {
        TotalCarb = totalCarb;
    }

    public String getTotalFat() {
        return TotalFat;
    }

    public void setTotalFat(String totalFat) {
        TotalFat = totalFat;
    }

    public String getTotalFiber() {
        return TotalFiber;
    }

    public void setTotalFiber(String totalFiber) {
        TotalFiber = totalFiber;
    }

    public String getTotalProtein() {
        return TotalProtein;
    }

    public void setTotalProtein(String totalProtein) {
        TotalProtein = totalProtein;
    }

    public ArrayList<RecipeDataDescriptionModel> getIngredient() {
        return Ingredient;
    }

    public void setIngredient(ArrayList<RecipeDataDescriptionModel> ingredient) {
        Ingredient = ingredient;
    }

    public String getProcedure() {
        return Procedure;
    }

    public void setProcedure(String procedure) {
        Procedure = procedure;
    }
}
