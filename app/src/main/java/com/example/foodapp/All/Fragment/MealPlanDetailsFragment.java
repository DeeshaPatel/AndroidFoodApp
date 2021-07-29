package com.example.foodapp.All.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Adapter.MealPlanDetailsAdapter;
import com.example.foodapp.All.Database.Service.MealPlanMealIngredientUpsertDto;
import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MealPlanDetailsFragment extends Fragment {

    RecyclerView ing,method;
    ArrayList<LibraryArticleModel> models,models1;
    TextView des,name;
    String s_name,s_notes;
    ArrayList<MealPlanMealIngredientUpsertDto> indredients;

    public MealPlanDetailsFragment(String s_name, String s_notes, ArrayList<MealPlanMealIngredientUpsertDto> ingredients)
    {
        this.s_name = s_name;
        this.s_notes = s_notes;
        this.indredients = ingredients;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_plan_details, container, false);

        ing = (RecyclerView)view.findViewById(R.id.rcv_library_article_ingredients);
        method = (RecyclerView)view.findViewById(R.id.rcv_library_article_method);
        des = (TextView)view.findViewById(R.id.library_article_description);
        name = (TextView)view.findViewById(R.id.txt_name_of_meal_plan);

        name.setText(s_name);
        des.setText(s_notes);

//        models = new ArrayList<>();
//        models.add(new LibraryArticleModel("ing1"));
//        models.add(new LibraryArticleModel("ing2"));
//        models.add(new LibraryArticleModel("ing3"));
//        models.add(new LibraryArticleModel("ing4"));
//        models.add(new LibraryArticleModel("ing5"));
//        models.add(new LibraryArticleModel("ing6"));
//        models.add(new LibraryArticleModel("ing7"));

        MealPlanDetailsAdapter foodDiaryMealaAdapter = new MealPlanDetailsAdapter(getContext(),indredients);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ing.setLayoutManager(linearLayoutManager);
        ing.setAdapter(foodDiaryMealaAdapter);


//        models1 = new ArrayList<>();
//        models1.add(new LibraryArticleModel("step 1"));
//        models1.add(new LibraryArticleModel("step 2"));
//        models1.add(new LibraryArticleModel("step 3"));
//        models1.add(new LibraryArticleModel("step 4"));
//        models1.add(new LibraryArticleModel("step 5"));
//
//        LibraryArticleAdapter foodDiaryMealaAdapter1 = new LibraryArticleAdapter(getContext(),models);
//        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        method.setLayoutManager(linearLayoutManager1);
//        method.setAdapter(foodDiaryMealaAdapter1);

        return view;
    }
}