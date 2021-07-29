package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.foodapp.R;

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