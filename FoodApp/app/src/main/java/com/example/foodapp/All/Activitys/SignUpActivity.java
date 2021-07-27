package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.foodapp.R;

public class SignUpActivity extends AppCompatActivity {

    RelativeLayout rlsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        rlsignup=findViewById(R.id.rlsignup);
        rlsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),PersonalDetails.class);
                startActivity(intent);

            }
        });
    }
}