package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.All.Adapter.CustomCalendar_WithourDisplay_Two;
import com.example.foodapp.All.Adapter.MealPlanMainAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.Data;
import com.example.foodapp.All.Database.Service.GetSliderImageDataModel;
import com.example.foodapp.All.Database.Service.GetSliderImageMainModel;
import com.example.foodapp.All.Database.Service.MealPlanMealUpsertDto;
import com.example.foodapp.All.Database.Service.MealPlanModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.All.Fragment.MealPlanFragment;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaunchPage extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_page);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sharedPreferences = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
                token = sharedPreferences.getString("token","");

                if(token.isEmpty())
                {
                    final Intent mainIntent = new Intent(LaunchPage.this, Splash.class);
                    startActivity(mainIntent);
                    finish();
                }
                else
                {
                    final Intent i = new Intent(LaunchPage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }



            }
//            }
        }, 1500);
    }

}