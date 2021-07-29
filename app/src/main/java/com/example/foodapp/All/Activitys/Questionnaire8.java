package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.Question7Adapter;
import com.example.foodapp.All.Models.QuestionHolder;
import com.example.foodapp.R;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class Questionnaire8 extends AppCompatActivity {

    Button rlSkip,rlNext;
    RecyclerView rvProtein,rvGrains,rvFruits,rvdairy_milk_type;
    ImageView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_questionnaire8);

        rlNext = (Button) findViewById(R.id.rlNext);
        rlSkip = (Button) findViewById(R.id.rlSkip);

        back = (ImageView)findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Questionnaire7.class);
                startActivity(i);
            }
        });

        rvProtein = (RecyclerView)findViewById(R.id.rvProtein);
        QuestionHolder[] questionHolders = new QuestionHolder[]{
                new QuestionHolder("Small"),
                new QuestionHolder("Medium"),
                new QuestionHolder("Large"),
                new QuestionHolder("Extra Large"),

        };
        Question7Adapter questionAdapter = new Question7Adapter(questionHolders);
        rvProtein.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        rvProtein.setLayoutManager(layoutManager);
        rvProtein.setAdapter(questionAdapter);

        rvGrains = (RecyclerView)findViewById(R.id.rvGrains);
        QuestionHolder[] questionHolders1 = new QuestionHolder[]{
                new QuestionHolder("Soy"),
                new QuestionHolder("Tomato"),
                new QuestionHolder("Almond"),
                new QuestionHolder("Oat"),
                new QuestionHolder("Coconut"),
                new QuestionHolder("Full Cream"),
                new QuestionHolder("Skim"),


        };
        Question7Adapter questionAdapter1 = new Question7Adapter(questionHolders1);
        rvGrains.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager1 = new FlexboxLayoutManager(this);
        layoutManager1.setFlexDirection(FlexDirection.ROW);
        layoutManager1.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager1.setAlignItems(AlignItems.FLEX_START);
        rvGrains.setLayoutManager(layoutManager1);
        rvGrains.setAdapter(questionAdapter1);


        rvFruits = (RecyclerView)findViewById(R.id.rvFruits);
        QuestionHolder[] questionHolders2 = new QuestionHolder[]{
                new QuestionHolder("Cappuccino"),
                new QuestionHolder("Latte"),
                new QuestionHolder("Long Black"),
                new QuestionHolder("Frappe"),
                new QuestionHolder("Iced Drink"),
                new QuestionHolder("Flat white"),
                new QuestionHolder("Short black"),
                new QuestionHolder("Mocha"),



        };


        Question7Adapter questionAdapter2 = new Question7Adapter(questionHolders2);
        rvFruits.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager2 = new FlexboxLayoutManager(this);
        layoutManager2.setFlexDirection(FlexDirection.ROW);
        layoutManager2.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager2.setAlignItems(AlignItems.FLEX_START);
        rvFruits.setLayoutManager(layoutManager2);
        rvFruits.setAdapter(questionAdapter2);


        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Questionnaire8.this,Questionnaire9.class);
                startActivity(i);
            }
        });

        QuestionHolder[] questionHolders3 = new QuestionHolder[]{
                new QuestionHolder("Sour Cream"),
                new QuestionHolder("Soy Milk"),
                new QuestionHolder("Cheddar Cheese"),
                new QuestionHolder("Full Cream Milk"),
                new QuestionHolder("Nut Milk"),
                new QuestionHolder("Feta"),
                new QuestionHolder("Lite Milk"),
                new QuestionHolder("Greek Yogurt"),
                new QuestionHolder("Halloumi"),
                new QuestionHolder("Oat Milk"),
                new QuestionHolder("Coconut Milk"),
                new QuestionHolder("Coconut Yogurt"),
                new QuestionHolder("High Protein Yogurt (YoPro)"),
        };

        rvdairy_milk_type = (RecyclerView)findViewById(R.id.rvdairy_milk_type);

        Question7Adapter questionAdapter3 = new Question7Adapter(questionHolders3);
        rvdairy_milk_type.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager3 = new FlexboxLayoutManager(this);
        layoutManager3.setFlexDirection(FlexDirection.ROW);
        layoutManager3.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager3.setAlignItems(AlignItems.FLEX_START);
        rvdairy_milk_type.setLayoutManager(layoutManager3);
        rvdairy_milk_type.setAdapter(questionAdapter3);


        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Questionnaire8.this,Questionnaire9.class);
                startActivity(i);
            }
        });




    }
}
