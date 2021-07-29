package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.MealPlanFragment;
import com.example.foodapp.All.Fragment.RecipeViewDetailsFragment;
import com.example.foodapp.All.Models.RecipeModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    Context context;
    ArrayList<RecipeModel> recipeModels;

    public RecipeAdapter(Context context,ArrayList<RecipeModel> recipeModels)
    {
        this.context = context;
        this.recipeModels = recipeModels;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_recipe, parent, false);
        return new RecipeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {

        RecipeModel recipeModel = recipeModels.get(position);
        holder.cal.setText(recipeModel.getCal());
        holder.mealname.setText(recipeModel.getName());
        holder.image.setImageResource(recipeModel.getId());
        holder.r_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                RecipeViewDetailsFragment myFragment = new RecipeViewDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView mealname,cal;
        RelativeLayout r_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.img_view_recipe);
            mealname = (TextView)itemView.findViewById(R.id.recipe_meal_name);
            cal = (TextView)itemView.findViewById(R.id.recipe_meal_cal);
            r_view = (RelativeLayout) itemView.findViewById(R.id.rl_view_recipe);

        }
    }


}
