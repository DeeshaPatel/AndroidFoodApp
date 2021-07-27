package com.example.foodapp.All.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodapp.All.Adapter.PickPlanAdapter;
import com.example.foodapp.All.Fragment.Add_Custom_Goal_Fragment;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Fragment.FoodDiaryNutritionView;
import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.All.Models.PickYourPlanModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MealPlanTemplateFragment extends Fragment {

    ImageView i1;
    RecyclerView recyclerView;
    ArrayList<PickYourPlanModel> pickYourPlanModels;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_plan_template, container, false);
        recyclerView = view.findViewById(R.id.rcv_pick_your_plan_data);

        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FoodDiaryMainView myFragment = new FoodDiaryMainView();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        pickYourPlanModels = new ArrayList<>();
        pickYourPlanModels.add(new PickYourPlanModel("VEGAN","2000","120","50","120"));
        pickYourPlanModels.add(new PickYourPlanModel("CLASSIC","1800","140","50","140"));
        pickYourPlanModels.add(new PickYourPlanModel("PESCATARIAN","1600","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("GLUTEN FREE","1500","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("VEGETARIEN","1400","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("LOW CARB","2000","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("HIGH CARB","1800","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("VEGAN","1600","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("CLASSIC","1600","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("PESCATARIAN","1500","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("GLUTEN FREE","1400","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("VEGETARIAN","1300","150","50","150"));
        pickYourPlanModels.add(new PickYourPlanModel("LOW CARB","1200","150","50","150"));

        PickPlanAdapter pickPlanAdapter = new PickPlanAdapter(getContext(),pickYourPlanModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(pickPlanAdapter);


        return view;
    }
}