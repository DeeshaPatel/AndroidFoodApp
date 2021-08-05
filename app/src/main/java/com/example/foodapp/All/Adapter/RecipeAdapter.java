package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.RecipeDataModel;
import com.example.foodapp.All.Database.Service.RecipeSubDataModel;
import com.example.foodapp.All.Fragment.MealPlanFragment;
import com.example.foodapp.All.Fragment.RecipeFragment;
import com.example.foodapp.All.Fragment.RecipeViewDetailsFragment;
import com.example.foodapp.All.Models.RecipeModel;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    Context context;
    ArrayList<RecipeSubDataModel> recipeModels;

    public RecipeAdapter(Context context,ArrayList<RecipeSubDataModel> recipeModels)
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
    public void onBindViewHolder(@NonNull final RecipeAdapter.ViewHolder holder, final int position) {

        holder.mealname.setText(recipeModels.get(position).getRecipeName());

        Picasso.get().load(recipeModels.get(position).getImagePath()).into(holder.image);


//        try {
//            URL url = new URL(recipeModels.get(position).getImagePath());
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            holder.image.setImageBitmap(image);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        holder.r_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                RecipeViewDetailsFragment myFragment = new RecipeViewDetailsFragment(recipeModels.get(position).getIngredient(),recipeModels.get(position).getNotes(),recipeModels.get(position).getTotalCarb(),recipeModels.get(position).getTotalFat(),recipeModels.get(position).getTotalFiber(),recipeModels.get(position).getTotalProtein(),recipeModels.get(position).getProcedure(),recipeModels.get(position).getImagePath());
                activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.framelayout, myFragment).commit();
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
        CardView card_view_recipe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.img_view_recipe);
            mealname = (TextView)itemView.findViewById(R.id.recipe_meal_name);
            cal = (TextView)itemView.findViewById(R.id.recipe_meal_cal);
            card_view_recipe = itemView.findViewById(R.id.card_view_recipe);
            r_view = (RelativeLayout) itemView.findViewById(R.id.rl_view_recipe);

        }
    }
}
