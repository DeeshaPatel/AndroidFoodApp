package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.RecipeDataDescriptionModel;
import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class RecipeDescriptionIngredientAdapter extends RecyclerView.Adapter<RecipeDescriptionIngredientAdapter.ViewHolder>{

    Context context;
    ArrayList<RecipeDataDescriptionModel> data;

    public RecipeDescriptionIngredientAdapter(Context context, ArrayList<RecipeDataDescriptionModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecipeDescriptionIngredientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_library_article, parent, false);
        return new RecipeDescriptionIngredientAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDescriptionIngredientAdapter.ViewHolder holder, int position) {

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
