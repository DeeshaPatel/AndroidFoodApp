package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodapp.All.Fragment.ChatMainPageFragment;
import com.example.foodapp.All.Fragment.CheckIn.CheckInFragmentHomePage;
import com.example.foodapp.All.Fragment.CheckIn.CheckinFragment;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.All.Fragment.MealPlanFragment;
import com.example.foodapp.All.Fragment.PersonalDetailsFragment;
import com.example.foodapp.All.Fragment.SettingFragment;
import com.example.foodapp.R;

public class
MainActivity extends AppCompatActivity {

  public static   LinearLayout llHome,llFood,llCheckin,llSetting;
    FragmentManager fragmentManager;
    ImageView logo;
    ImageView home,checkin,setting,food;
    FrameLayout framelayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llSetting=findViewById(R.id.llSetting);
        llCheckin=findViewById(R.id.llCheckin);
        llHome=findViewById(R.id.llHome);
        llFood=findViewById(R.id.llFood);

        home = findViewById(R.id.image_home);
        food = findViewById(R.id.image_food);
        checkin = findViewById(R.id.image_check_in);
        setting = findViewById(R.id.image_setting);

       framelayout=findViewById(R.id.framelayout);
       logo = findViewById(R.id.logo_main_page);

        llHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home.setImageResource(R.drawable.home_yellow);
                food.setImageResource(R.drawable.diary);
                checkin.setImageResource(R.drawable.check_in_logo);
                setting.setImageResource(R.drawable.settings);
                Fragment fragment = new HomeFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        llCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.homeicon_grey);
                food.setImageResource(R.drawable.diary);
                checkin.setImageResource(R.drawable.checkin_yellow);
                setting.setImageResource(R.drawable.settings);

                Fragment fragment = new CheckinFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        llSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                home.setImageResource(R.drawable.homeicon_grey);
                food.setImageResource(R.drawable.diary);
                checkin.setImageResource(R.drawable.check_in_logo);
                setting.setImageResource(R.drawable.setting_yellow);

                Fragment fragment = new ChatMainPageFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        llFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                home.setImageResource(R.drawable.homeicon_grey);
                food.setImageResource(R.drawable.yellow_food);
                checkin.setImageResource(R.drawable.check_in_logo);
                setting.setImageResource(R.drawable.settings);

                Fragment fragment = new FoodDiaryMainView();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                home.setImageResource(R.drawable.homeicon_grey);
                food.setImageResource(R.drawable.diary);
                checkin.setImageResource(R.drawable.check_in_logo);
                setting.setImageResource(R.drawable.settings);

                Fragment fragment = new MealPlanFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        Fragment fraggy1 = new HomeFragment();
        fragmentTransaction.replace(R.id.framelayout, fraggy1);
        fragmentTransaction.commit();


        framelayout = new FrameLayout(this);

    }
}