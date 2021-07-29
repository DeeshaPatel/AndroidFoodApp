package com.example.foodapp.All.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.All.Adapter.LibraryMainPageAdapter;
import com.example.foodapp.All.Models.LibraryMainPageModel;
import com.example.foodapp.R;

import java.util.ArrayList;


public class LibraryHomePageFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<LibraryMainPageModel> models;
    ImageView back;

    TextView nutrition,fitness,health,food;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library_home_page, container, false);

        recyclerView = view.findViewById(R.id.rcv_library_main_page);
        nutrition = view.findViewById(R.id.library_home_nutrition);
        fitness = view.findViewById(R.id.library_home_fitness);
        health = view.findViewById(R.id.library_home_health);
        food = view.findViewById(R.id.library_home_food);

        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutrition.setTextColor(getResources().getColor(R.color.yellow));
                fitness.setTextColor(getResources().getColor(R.color.white));
                health.setTextColor(getResources().getColor(R.color.white));
                food.setTextColor(getResources().getColor(R.color.white));

            }
        });

        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutrition.setTextColor(getResources().getColor(R.color.white));
                fitness.setTextColor(getResources().getColor(R.color.yellow));
                health.setTextColor(getResources().getColor(R.color.white));
                food.setTextColor(getResources().getColor(R.color.white));

            }
        });

        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutrition.setTextColor(getResources().getColor(R.color.white));
                fitness.setTextColor(getResources().getColor(R.color.white));
                health.setTextColor(getResources().getColor(R.color.yellow));
                food.setTextColor(getResources().getColor(R.color.white));

            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nutrition.setTextColor(getResources().getColor(R.color.white));
                fitness.setTextColor(getResources().getColor(R.color.white));
                health.setTextColor(getResources().getColor(R.color.white));
                food.setTextColor(getResources().getColor(R.color.yellow));

            }
        });

        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                HomeFragment myFragment = new HomeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        models = new ArrayList<>();
        models.add(new LibraryMainPageModel(R.drawable.library1,"Meal 1"));
        models.add(new LibraryMainPageModel(R.drawable.library2,"Meal 2"));
        models.add(new LibraryMainPageModel(R.drawable.library3,"Meal 3"));

        LibraryMainPageAdapter libraryMainPageAdapter = new LibraryMainPageAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(libraryMainPageAdapter);
        recyclerView.setNestedScrollingEnabled(false);


        return view;
    }
}