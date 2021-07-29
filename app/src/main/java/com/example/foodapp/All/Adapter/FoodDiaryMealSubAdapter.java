package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.FoodDiaryMealSubItemModel;
import com.example.foodapp.R;

import java.util.List;

public class FoodDiaryMealSubAdapter extends RecyclerView.Adapter<FoodDiaryMealSubAdapter.ViewHolder> {

    Context context;
    List<FoodDiaryMealSubItemModel> foodDiaryMealModels;

    public FoodDiaryMealSubAdapter(Context context, List<FoodDiaryMealSubItemModel> foodDiaryMealModels){
        this.context = context;
        this.foodDiaryMealModels = foodDiaryMealModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_food_dairy_sub_module, parent, false);
        return new FoodDiaryMealSubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodDiaryMealSubItemModel model = foodDiaryMealModels.get(position);
        holder.name.setText(model.getFood_name());
        holder.cal.setText(model.getCal());
        holder.protein.setText(model.getProtain());
        holder.carb.setText(model.getCarb());
        holder.fat.setText(model.getFat());
    }

    @Override
    public int getItemCount() {
        return foodDiaryMealModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,cal,protein,carb,fat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name_of_meal);
            cal = (TextView)itemView.findViewById(R.id.number_of_cal);
            protein = (TextView)itemView.findViewById(R.id.number_of_protein);
            carb = (TextView)itemView.findViewById(R.id.number_of_carbs);
            fat = (TextView)itemView.findViewById(R.id.number_of_fat);

        }
    }

}
