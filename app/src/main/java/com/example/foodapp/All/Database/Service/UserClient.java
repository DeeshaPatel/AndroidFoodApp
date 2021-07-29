package com.example.foodapp.All.Database.Service;



import com.example.foodapp.All.Models.LoginUser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserClient {

    @POST("/api/Login/CustomerLogin")
    @Headers("Content-Type: application/json")
    Call<LoginUser> userLogin(@Body LoginRequest loginRequest);


    @GET("/api/MealPlan/GetMealPlans")
    Call<MealPlanModel> getAllData(@Query("date") String date, @Query("PageNo") int pageno, @Query("PageSize") int pagesize, @Header("Authorization") String auth);

}

