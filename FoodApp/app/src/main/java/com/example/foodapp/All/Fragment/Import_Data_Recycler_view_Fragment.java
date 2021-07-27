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

import com.example.foodapp.All.Adapter.ImportMealAdapter;
import com.example.foodapp.All.Models.ImportMealData;
import com.example.foodapp.R;

import java.util.ArrayList;

public class Import_Data_Recycler_view_Fragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ImportMealData>  data;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_import_food_diary, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_import_data);

        data = new ArrayList<>();
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));

        ImportMealAdapter adapter = new ImportMealAdapter(getContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);


        return view;
    }
}
