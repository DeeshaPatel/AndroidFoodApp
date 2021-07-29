package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.foodapp.All.Adapter.RecipeAdapter;
import com.example.foodapp.All.Models.RecipeModel;
import com.example.foodapp.R;

import java.util.ArrayList;


public class RecipeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<RecipeModel> recipeModels;
    LinearLayout l1,l2,l3,l4,l5,l6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        l1 = (LinearLayout)view.findViewById(R.id.recipe_popular);
        l2 = (LinearLayout)view.findViewById(R.id.recipe_chicken);
        l3 = (LinearLayout)view.findViewById(R.id.recipe_beef);
        l4 = (LinearLayout)view.findViewById(R.id.recipe_seafood);
        l5 = (LinearLayout)view.findViewById(R.id.recipe_drinks);
        l6 = (LinearLayout)view.findViewById(R.id.recipe_vogan);

        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.yellow));
                l2.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l3.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l4.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l5.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l6.setBackgroundColor(getResources().getColor(R.color.tab_color));

            }
        });

        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l2.setBackgroundColor(getResources().getColor(R.color.yellow));
                l3.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l4.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l5.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l6.setBackgroundColor(getResources().getColor(R.color.tab_color));

            }
        });

        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l2.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l3.setBackgroundColor(getResources().getColor(R.color.yellow));
                l4.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l5.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l6.setBackgroundColor(getResources().getColor(R.color.tab_color));

            }
        });

        l4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l2.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l3.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l4.setBackgroundColor(getResources().getColor(R.color.yellow));
                l5.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l6.setBackgroundColor(getResources().getColor(R.color.tab_color));

            }
        });
        l5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l2.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l3.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l4.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l5.setBackgroundColor(getResources().getColor(R.color.yellow));
                l6.setBackgroundColor(getResources().getColor(R.color.tab_color));

            }
        });
        l6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l2.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l3.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l4.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l5.setBackgroundColor(getResources().getColor(R.color.tab_color));
                l6.setBackgroundColor(getResources().getColor(R.color.yellow));

            }
        });


        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_recipe);
        recipeModels = new ArrayList<>();
        recipeModels.add(new RecipeModel("Meal 1","200",R.drawable.clip1));
        recipeModels.add(new RecipeModel("Meal 1","200",R.drawable.clip3));
        recipeModels.add(new RecipeModel("Meal 1","200",R.drawable.clip4));
        recipeModels.add(new RecipeModel("Meal 1","200",R.drawable.clip6));

        RecipeAdapter recipeAdapter = new RecipeAdapter(getContext(),recipeModels);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(recipeAdapter);

        return view;
    }
}