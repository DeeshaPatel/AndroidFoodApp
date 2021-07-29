package com.example.foodapp.All.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.All.Activitys.Questionnaire6;
import com.example.foodapp.All.Activitys.Questionnaire7;
import com.example.foodapp.All.Activitys.Questionnaire8;
import com.example.foodapp.R;

public class Profile_Food_and_Beverage_Fragment extends Fragment {

    Context context;
    CardView food_likes,food_dislikes,beverage_likes,beverage_dislike,dairy_dislike,medical;

    Profile_Food_and_Beverage_Fragment(Context context){
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile__food_and__beverage_, container, false);

        food_likes = (CardView)view.findViewById(R.id.food_and_beverage_food_likes);
        food_dislikes = (CardView)view.findViewById(R.id.food_and_beverage_food_dislikes);
        beverage_likes = (CardView)view.findViewById(R.id.food_and_beverage_beverage_likes);
        beverage_dislike = (CardView)view.findViewById(R.id.food_and_beverage_beverage_dislikes);
        dairy_dislike = (CardView)view.findViewById(R.id.food_and_beverage_daily_dislikes);
        medical = (CardView)view.findViewById(R.id.food_and_beverage_medical_condition);

        food_likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment_Que_6 myFragment = new Fragment_Que_6();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

        food_dislikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment_Que_7 myFragment = new Fragment_Que_7();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });
        beverage_likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment_Que_8 myFragment = new Fragment_Que_8();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });
        beverage_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragmner_Que_Beverage_Dislike myFragment = new Fragmner_Que_Beverage_Dislike();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });
        dairy_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment_Que_8 myFragment = new Fragment_Que_8();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment_Que_2 myFragment = new Fragment_Que_2();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }
}