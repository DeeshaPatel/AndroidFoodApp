package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.MealPlanMealIngredientUpsertDto;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MealPlanDetailsAdapter extends RecyclerView.Adapter<MealPlanDetailsAdapter.ViewHolder>{

    Context context;
    ArrayList<MealPlanMealIngredientUpsertDto> data;

    public MealPlanDetailsAdapter(Context context, ArrayList<MealPlanMealIngredientUpsertDto> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MealPlanDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_library_article, parent, false);
        return new MealPlanDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealPlanDetailsAdapter.ViewHolder holder, int position) {

        holder.ing.setText(data.get(position).getFoodName()+" - "+data.get(position).getFoodAmount()+" "+data.get(position).getUnitName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView ing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ing = (TextView) itemView.findViewById(R.id.library_article_item_ingredients);


        }
    }
}
