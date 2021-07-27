package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MealPlanMealUpsertDto {

    @SerializedName("MealName")
    @Expose
    private String MealName;

    @SerializedName("MealPlanMealIngredientUpsertDto")
    @Expose
    ArrayList<MealPlanMealIngredientUpsertDto> mealPlanMealIngredientUpsertDto;

    public MealPlanMealUpsertDto(String MealName,ArrayList<MealPlanMealIngredientUpsertDto> mealPlanMealIngredientUpsertDto) {
        this.MealName = MealName;
        this.mealPlanMealIngredientUpsertDto = mealPlanMealIngredientUpsertDto;

    }

    public String getMealName() {
        return MealName;
    }

    public void setMealName(String mealName) {
        this.MealName = mealName;
    }

    public ArrayList<MealPlanMealIngredientUpsertDto> getMealPlanMealIngredientUpsertDto() {
        return mealPlanMealIngredientUpsertDto;
    }

    public void setMealPlanMealIngredientUpsertDto(ArrayList<MealPlanMealIngredientUpsertDto> mealPlanMealIngredientUpsertDto) {
        this.mealPlanMealIngredientUpsertDto = mealPlanMealIngredientUpsertDto;
    }
}