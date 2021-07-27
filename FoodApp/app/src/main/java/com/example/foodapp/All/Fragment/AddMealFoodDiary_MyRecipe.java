package com.example.foodapp.All.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Adapter.FoodDiaryMealSubAdapter;
import com.example.foodapp.All.Adapter.LibraryFoodAdapter;
import com.example.foodapp.All.Adapter.MyRecipeAdapter;
import com.example.foodapp.All.Models.FoodDiaryMealSubItemModel;
import com.example.foodapp.All.Models.LibraryFoodModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class AddMealFoodDiary_MyRecipe extends Fragment {

    RecyclerView recyclerView;
    ArrayList<FoodDiaryMealSubItemModel> models;
    Button newRecipe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_my_recipe, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_library_my_recipe_data);
        newRecipe = (Button)view.findViewById(R.id.btn_new_recipe);

        newRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                AddMealFoodDiary_MyRecipe_New_Recipe myFragment = new AddMealFoodDiary_MyRecipe_New_Recipe();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();


            }
        });

        models = new ArrayList<>();
        models.add(new FoodDiaryMealSubItemModel("Egg","430g","20g","23.0g","3.3 cal"));
        models.add(new FoodDiaryMealSubItemModel("Banana","430g","20g","23.0g","3.3 cal"));
        models.add(new FoodDiaryMealSubItemModel("Tomatoes","430g","20g","23.0g","3.3 cal"));
        models.add(new FoodDiaryMealSubItemModel("Raw","430g","20g","23.0g","3.3 cal"));
        models.add(new FoodDiaryMealSubItemModel("Ready Pasta","430g","20g","23.0g","3.3 cal"));
        models.add(new FoodDiaryMealSubItemModel("Chicken Breast","430g","20g","23.0g","3.3 cal"));

        MyRecipeAdapter adapter = new MyRecipeAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;

    }
}
