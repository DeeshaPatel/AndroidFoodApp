package com.example.foodapp.All.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Adapter.LibraryArticleAdapter;
import com.example.foodapp.All.Adapter.MealPlanDetailsAdapter;
import com.example.foodapp.All.Adapter.RecipeDescriptionIngredientAdapter;
import com.example.foodapp.All.Database.Service.RecipeDataDescriptionModel;
import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeViewDetailsFragment extends Fragment {

    RecyclerView ing;
    TextView method;
    ArrayList<LibraryArticleModel> models,models1;
    TextView des;
    ImageView imageView;
    ArrayList<RecipeDataDescriptionModel> dataDescriptionModels;
    String s_description,carb,fat,fiber,protein,procedure,image;
    TextView txt_fiber,txt_protein,txt_carbs,txt_fat;

    public RecipeViewDetailsFragment(ArrayList<RecipeDataDescriptionModel> dataDescriptionModels, String s_description,String carb,String fat, String fiber ,String protein, String procedure, String image)
    {
        this.dataDescriptionModels = dataDescriptionModels;
        this.s_description = s_description;
        this.carb = carb;
        this.fat = fat;
        this.fiber = fiber;
        this.protein = protein;
        this.procedure = procedure;
        this.image = image;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_view_details, container, false);

        ing = (RecyclerView)view.findViewById(R.id.rcv_library_article_ingredients);
        method = view.findViewById(R.id.rcv_library_article_method);
        des = (TextView)view.findViewById(R.id.library_article_description);
        imageView = (ImageView)view.findViewById(R.id.img_library_article);

        txt_protein = view.findViewById(R.id.recipe_details_protein);
        txt_carbs = view.findViewById(R.id.recipe_details_carbs);
        txt_fat = view.findViewById(R.id.recipe_details_fats);
        txt_fiber = view.findViewById(R.id.recipe_details_fiber);

        Picasso.get().load(image).into(imageView);

        txt_protein.setText(protein);
        txt_fiber.setText(fiber);
        txt_fat.setText(fat);
        txt_carbs.setText(carb);
        des.setText(s_description);
        method.setText(procedure);

        RecipeDescriptionIngredientAdapter adapter = new RecipeDescriptionIngredientAdapter(getContext(),dataDescriptionModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ing.setLayoutManager(linearLayoutManager);
        ing.setAdapter(adapter);

        return view;
    }
}