package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapp.R;

public class Questionnaire2 extends AppCompatActivity {

    Button rlSkip,rlNext;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questionnaire2);

        back = (ImageView)findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Questionnaire1.class);
                startActivity(i);
            }
        });

        rlNext = (Button) findViewById(R.id.rlNext);
        rlSkip = (Button) findViewById(R.id.rlSkip);

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Questionnaire2.this,Questionnaire3.class);
                startActivity(i);
            }
        });


    }
}
