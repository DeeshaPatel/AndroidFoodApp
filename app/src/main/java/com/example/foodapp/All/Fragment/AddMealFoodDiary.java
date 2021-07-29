package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.R;


public class AddMealFoodDiary extends Fragment {

    FrameLayout layout;
    FragmentManager fragmentManager;
    TextView o1,o2,o3,o4;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main_add__request_meal, container, false);
        layout = (FrameLayout) view.findViewById(R.id.add_food_fragment);

         back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FoodDiaryMainView myFragment = new FoodDiaryMainView();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        o1 = (TextView)view.findViewById(R.id.add_fragment_food_option);
        o2 = (TextView)view.findViewById(R.id.add_fragment_request_food_option);
        o3 = (TextView)view.findViewById(R.id.add_fragment_my_recipe_option);
        o4 = (TextView)view.findViewById(R.id.add_fragment_recipe_discovery_option);

        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o1.setTextColor(getResources().getColor(R.color.yellow));
                o3.setTextColor(getResources().getColor(R.color.white));
                Fragment fragment = new AddMealFoodDiary_Food();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.add_food_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                RequestFoodFragment myFragment = new RequestFoodFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });

        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                o3.setTextColor(getResources().getColor(R.color.yellow));
                o1.setTextColor(getResources().getColor(R.color.white));
                Fragment fragment = new AddMealFoodDiary_MyRecipe();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.add_food_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        Fragment fragment = new AddMealFoodDiary_Food();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.add_food_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


        layout = new FrameLayout(getContext());


        return view;



    }


}