package com.example.foodapp.All.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Activitys.Questionnaire5;
import com.example.foodapp.All.Activitys.Questionnaire8;
import com.example.foodapp.All.Activitys.Questionnaire9;
import com.example.foodapp.All.Models.Question7Adapter;
import com.example.foodapp.All.Models.QuestionHolder;
import com.example.foodapp.R;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class Fragment_Que_8 extends Fragment {

    Button rlSkip,rlNext;
    RecyclerView rvProtein,rvGrains,rvFruits,rvdairy_milk_type;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_questionnaire8, container, false);
        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Questionnaire5.class);
                startActivity(i);
            }
        });

        rlNext = (Button) view.findViewById(R.id.rlNext);
        rlSkip = (Button)view.findViewById(R.id.rlSkip);

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProfileFragment myFragment = new ProfileFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

        rlSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProfileFragment myFragment = new ProfileFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });

        rvProtein = (RecyclerView)view.findViewById(R.id.rvProtein);
        QuestionHolder[] questionHolders = new QuestionHolder[]{
                new QuestionHolder("Small"),
                new QuestionHolder("Medium"),
                new QuestionHolder("Large"),
                new QuestionHolder("Extra Large"),

        };
        Question7Adapter questionAdapter = new Question7Adapter(questionHolders);
        rvProtein.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        rvProtein.setLayoutManager(layoutManager);
        rvProtein.setAdapter(questionAdapter);

        rvGrains = (RecyclerView)view.findViewById(R.id.rvGrains);
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
        FlexboxLayoutManager layoutManager1 = new FlexboxLayoutManager(getContext());
        layoutManager1.setFlexDirection(FlexDirection.ROW);
        layoutManager1.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager1.setAlignItems(AlignItems.FLEX_START);
        rvGrains.setLayoutManager(layoutManager1);
        rvGrains.setAdapter(questionAdapter1);


        rvFruits = (RecyclerView)view.findViewById(R.id.rvFruits);
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
        FlexboxLayoutManager layoutManager2 = new FlexboxLayoutManager(getContext());
        layoutManager2.setFlexDirection(FlexDirection.ROW);
        layoutManager2.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager2.setAlignItems(AlignItems.FLEX_START);
        rvFruits.setLayoutManager(layoutManager2);
        rvFruits.setAdapter(questionAdapter2);


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

        rvdairy_milk_type =(RecyclerView)view.findViewById(R.id.rvdairy_milk_type);
        Question7Adapter questionAdapter3 = new Question7Adapter(questionHolders3);
        rvdairy_milk_type.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager3 = new FlexboxLayoutManager(getContext());
        layoutManager3.setFlexDirection(FlexDirection.ROW);
        layoutManager3.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager3.setAlignItems(AlignItems.FLEX_START);
        rvdairy_milk_type.setLayoutManager(layoutManager3);
        rvdairy_milk_type.setAdapter(questionAdapter3);



        return view;
    }
}
