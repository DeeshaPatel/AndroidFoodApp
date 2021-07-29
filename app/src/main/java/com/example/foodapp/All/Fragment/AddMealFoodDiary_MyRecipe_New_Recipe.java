package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.All.Adapter.LibraryFoodAdapter;
import com.example.foodapp.All.Models.LibraryFoodModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class AddMealFoodDiary_MyRecipe_New_Recipe extends Fragment {

    RecyclerView recyclerView;
    ArrayList<LibraryFoodModel> models;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_recipe_new_recipe, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_recipe_discovery);

        models = new ArrayList<>();
        models.add(new LibraryFoodModel("Egg","430g","3.3 cal"));
        models.add(new LibraryFoodModel("Banana","430g","3.3 cal"));
        models.add(new LibraryFoodModel("Tomatoes","430g","3.3 cal"));
        models.add(new LibraryFoodModel("Raw","430g","3.3 cal"));
        models.add(new LibraryFoodModel("Ready Pasta","430g","3.3 cal"));
        models.add(new LibraryFoodModel("Chicken Breast","430g","3.3 cal"));

        LibraryFoodAdapter adapter = new LibraryFoodAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }
}