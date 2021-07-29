package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.LibraryFoodModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class LibraryFoodAdapter extends RecyclerView.Adapter<LibraryFoodAdapter.ViewHolder> {

    Context context;
    ArrayList<LibraryFoodModel> foodDiaryMealModels;

    public LibraryFoodAdapter(Context context, ArrayList<LibraryFoodModel> foodDiaryMealModels){
        this.context = context;
        this.foodDiaryMealModels = foodDiaryMealModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_food_library, parent, false);
        return new LibraryFoodAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LibraryFoodModel model = foodDiaryMealModels.get(position);
        holder.name.setText(model.getName());
        holder.cal.setText(model.getCal());
        holder.gram.setText(model.getGram());

    }

    @Override
    public int getItemCount() {
        return foodDiaryMealModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,cal,gram;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name_of_food_library);
            cal = (TextView)itemView.findViewById(R.id.library_number_of_cal);
            gram = (TextView)itemView.findViewById(R.id.number_of_food);

        }
    }

}
