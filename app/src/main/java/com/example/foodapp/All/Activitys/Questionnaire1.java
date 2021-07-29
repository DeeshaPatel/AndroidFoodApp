package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.QuestionAdapter;
import com.example.foodapp.All.Models.QuestionHolder;
import com.example.foodapp.R;

import java.util.ArrayList;

public class Questionnaire1 extends AppCompatActivity {

    Button rlSkip,rlNext;
    RecyclerView recyclerView;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questionnaire1);

        rlNext = (Button) findViewById(R.id.rlNext);
        rlSkip = (Button) findViewById(R.id.rlSkip);

        back = (ImageView)findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PersonalDetails.class);
                startActivity(i);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.q1_recycler_view);


        QuestionHolder[] questionHolders = new QuestionHolder[]{
                new QuestionHolder("Fat loss"),
                new QuestionHolder("Muscle Gain"),
                new QuestionHolder("Reverse Diet"),
                new QuestionHolder("Sports Performance"),
        };


        QuestionAdapter questionAdapter = new QuestionAdapter(questionHolders);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionAdapter);

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Questionnaire1.this,Questionnaire2.class);
                startActivity(i);
            }
        });


    }
}
