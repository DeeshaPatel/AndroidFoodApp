package com.example.foodapp.All.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Adapter.LibraryFoodAdapter;
import com.example.foodapp.All.Models.LibraryFoodModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class AddMealFoodDiary_Food extends Fragment {

    RecyclerView recyclerView;
    ArrayList<LibraryFoodModel> models;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.add_food_slide1, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_library_food_data);

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
