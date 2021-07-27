package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.QuestionAdapter;
import com.example.foodapp.All.Models.QuestionHolder;
import com.example.foodapp.R;

public class Questionnaire3 extends AppCompatActivity {

    Button rlSkip,rlNext;
    RecyclerView recyclerView;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questionnaire3);


        back = (ImageView)findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Questionnaire2.class);
                startActivity(i);
            }
        });

        rlNext = (Button) findViewById(R.id.rlNext);
        rlSkip = (Button) findViewById(R.id.rlSkip);

        recyclerView = (RecyclerView)findViewById(R.id.q3_recycler_view);
        recyclerView.setNestedScrollingEnabled(false);


        QuestionHolder[] questionHolders = new QuestionHolder[]{
                new QuestionHolder("Sedentary: little or no exercise"),
                new QuestionHolder("Exercise 1-3 times/week"),
                new QuestionHolder("Exercise 4-5 times/week"),
                new QuestionHolder("Daily exercise or intense exercise 4 times/week"),
                new QuestionHolder("Intense exercise 6-7 times/week"),
                new QuestionHolder("Very intense exercise daily, or physical job"),
        };

        QuestionAdapter questionAdapter = new QuestionAdapter(questionHolders);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionAdapter);


        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Questionnaire3.this,Questionnaire4.class);
                startActivity(i);
            }
        });


    }
}
