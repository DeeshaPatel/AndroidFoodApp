package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foodapp.All.Adapter.LibraryArticleAdapter;
import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RecipeViewDetailsFragment extends Fragment {

    RecyclerView ing,method;
    ArrayList<LibraryArticleModel> models,models1;
    TextView des;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_view_details, container, false);

        ing = (RecyclerView)view.findViewById(R.id.rcv_library_article_ingredients);
        method = (RecyclerView)view.findViewById(R.id.rcv_library_article_method);
        des = (TextView)view.findViewById(R.id.library_article_description);

        models = new ArrayList<>();
        models.add(new LibraryArticleModel("ing1"));
        models.add(new LibraryArticleModel("ing2"));
        models.add(new LibraryArticleModel("ing3"));
        models.add(new LibraryArticleModel("ing4"));
        models.add(new LibraryArticleModel("ing5"));
        models.add(new LibraryArticleModel("ing6"));
        models.add(new LibraryArticleModel("ing7"));

        LibraryArticleAdapter foodDiaryMealaAdapter = new LibraryArticleAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ing.setLayoutManager(linearLayoutManager);
        ing.setAdapter(foodDiaryMealaAdapter);


        models1 = new ArrayList<>();
        models1.add(new LibraryArticleModel("step 1"));
        models1.add(new LibraryArticleModel("step 2"));
        models1.add(new LibraryArticleModel("step 3"));
        models1.add(new LibraryArticleModel("step 4"));
        models1.add(new LibraryArticleModel("step 5"));

        LibraryArticleAdapter foodDiaryMealaAdapter1 = new LibraryArticleAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        method.setLayoutManager(linearLayoutManager1);
        method.setAdapter(foodDiaryMealaAdapter1);



        return view;
    }
}