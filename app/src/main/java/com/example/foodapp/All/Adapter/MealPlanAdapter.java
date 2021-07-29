package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ImportMealData;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.ViewHolder>{

    Context context;
    ArrayList<ImportMealData> data;

    public MealPlanAdapter(Context context, ArrayList<ImportMealData> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_meal_plan, parent, false);
        return new MealPlanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ImportMealData model = data.get(position);
        holder.meal.setText(model.getMeal());
        holder.cal.setText(model.getCal());
        holder.pro.setText(model.getPro());
        holder.fat.setText(model.getFat());
        holder.carb.setText(model.getCarb());
        holder.ing.setText(model.getIng());
        holder.image.setImageResource(model.getId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView meal,ing,cal,pro,fat,carb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image_view_food_photo);
            meal = (TextView)itemView.findViewById(R.id.imported_meal_name);
            ing = (TextView) itemView.findViewById(R.id.imported_ing);
            fat = (TextView) itemView.findViewById(R.id.import_fat_data);
            pro = (TextView) itemView.findViewById(R.id.import_protein_data);
            carb = (TextView) itemView.findViewById(R.id.import_carbs_data);
            cal = (TextView) itemView.findViewById(R.id.import_calories_data);

        }
    }
}
