package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ShoppingListModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ViewHolder> {

    Context context;
    ArrayList<ShoppingListModel> foodDiaryMealModels;

    public ShoppingListAdapter(Context context, ArrayList<ShoppingListModel> foodDiaryMealModels){
        this.context = context;
        this.foodDiaryMealModels = foodDiaryMealModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_shopping_list, parent, false);
        return new ShoppingListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShoppingListModel model = foodDiaryMealModels.get(position);
        holder.meal.setText(model.getMeal());
        holder.ing1.setText(model.getI1());
        holder.ing2.setText(model.getI2());
        holder.ing3.setText(model.getI3());
        holder.ing4.setText(model.getI4());
        holder.time.setText(model.getTime());
        holder.image.setImageResource(model.getPhoto());
    }

    @Override
    public int getItemCount() {
        return foodDiaryMealModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView meal,ing1,ing2,ing3,ing4,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image_view_shopping_list);
            meal = (TextView)itemView.findViewById(R.id.shopping_meal);
            ing1 = (TextView)itemView.findViewById(R.id.ind1);
            ing2 = (TextView)itemView.findViewById(R.id.ind2);
            ing3 = (TextView)itemView.findViewById(R.id.ind3);
            ing4 = (TextView)itemView.findViewById(R.id.ind4);
            time = (TextView)itemView.findViewById(R.id.txt_shopping_time);

        }
    }

}
