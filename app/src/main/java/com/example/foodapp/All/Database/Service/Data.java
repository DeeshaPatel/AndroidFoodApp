package com.example.foodapp.All.Database.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("TotalProtein")
    @Expose
    float TotalProtein;

    @SerializedName("TotalFat")
    @Expose
    float TotalFat;

    @SerializedName("TotalCarb")
    @Expose
    float TotalCarb;

    @SerializedName("Totalcalories")
    @Expose
    float Totalcalories;

    @SerializedName("TotalFiber")
    @Expose
    float TotalFiber;

    @SerializedName("MealPlanMealUpsertDto")
    @Expose
    private List<MealPlanMealUpsertDto> mealPlanMealUpsertDto;

    public float getTotalProtein() {
        return TotalProtein;
    }

    public void setTotalProtein(float totalProtein) {
        TotalProtein = totalProtein;
    }

    public float getTotalFat() {
        return TotalFat;
    }

    public void setTotalFat(float totalFat) {
        TotalFat = totalFat;
    }

    public float getTotalCarb() {
        return TotalCarb;
    }

    public float getTotalFiber() {
        return TotalFiber;
    }

    public void setTotalFiber(float totalFiber) {
        TotalFiber = totalFiber;
    }

    public void setTotalCarb(float totalCarb) {
        TotalCarb = totalCarb;
    }

    public float getTotalcalories() {
        return Totalcalories;
    }

    public void setTotalcalories(float totalcalories) {
        Totalcalories = totalcalories;
    }

    public List<MealPlanMealUpsertDto> getMealPlanMealUpsertDto() {
        return mealPlanMealUpsertDto;
    }

    public void setMealPlanMealUpsertDto(List<MealPlanMealUpsertDto> mealPlanMealUpsertDto) {
        this.mealPlanMealUpsertDto = mealPlanMealUpsertDto;
    }

}
