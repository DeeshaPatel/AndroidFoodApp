package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.MealPlanMealIngredientUpsertDto;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.List;

public class MealPlanSubAdapter extends RecyclerView.Adapter<MealPlanSubAdapter.ViewHolder> {

    Context context;
    List<MealPlanMealIngredientUpsertDto> foodDiaryMealModels;

    public MealPlanSubAdapter(Context context, ArrayList<MealPlanMealIngredientUpsertDto> foodDiaryMealModels){
        this.context = context;
        this.foodDiaryMealModels = foodDiaryMealModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_nested_meal_data, parent, false);
        return new MealPlanSubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MealPlanMealIngredientUpsertDto model = foodDiaryMealModels.get(position);
        holder.name.setText(foodDiaryMealModels.get(position).getFoodName()+" - "+foodDiaryMealModels.get(position).getFoodAmount()+foodDiaryMealModels.get(position).getUnitName());

        holder.shopping_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return foodDiaryMealModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView shopping_cart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name_of_meal_details);
            shopping_cart = (ImageView)itemView.findViewById(R.id.nested_meal_data_shopping_Cart);

        }
    }

}
