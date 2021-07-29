package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecipeDataDescriptionModel {
    @SerializedName("FoodName")
    @Expose
    String FoodName;

    @SerializedName("Amount")
    @Expose
    String FoodAmount;

    @SerializedName("UnitName")
    @Expose
    String UnitName;

    RecipeDataDescriptionModel(String FoodName, String FoodAmount, String UnitName)
    {
        this.FoodName = FoodName;
        this.FoodAmount = FoodAmount;
        this.UnitName = UnitName;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodAmount() {
        return FoodAmount;
    }

    public void setFoodAmount(String foodAmount) {
        FoodAmount = foodAmount;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }
}