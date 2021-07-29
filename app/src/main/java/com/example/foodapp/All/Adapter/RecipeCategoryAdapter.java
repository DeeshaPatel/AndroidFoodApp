package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.RecipeCategorySubDataModel;
import com.example.foodapp.All.Database.Service.RecipeSubDataModel;
import com.example.foodapp.All.Fragment.RecipeFragment;
import com.example.foodapp.All.Fragment.RecipeViewDetailsFragment;
import com.example.foodapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeCategoryAdapter extends RecyclerView.Adapter<RecipeCategoryAdapter.ViewHolder>{

    Context context;
    ArrayList<RecipeCategorySubDataModel> recipeModels;
    private int selectedPosition = 0;


    public RecipeCategoryAdapter(Context context, ArrayList<RecipeCategorySubDataModel> recipeModels)
    {
        this.context = context;
        this.recipeModels = recipeModels;
    }

    @NonNull
    @Override
    public RecipeCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_recipe_catogories, parent, false);
        return new RecipeCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeCategoryAdapter.ViewHolder holder, final int position) {

        holder.mealname.setText(recipeModels.get(position).getName());

        Picasso.get().load(recipeModels.get(position).getCategoryImage()).into(holder.image);

//        try {
//            URL url = new URL(recipeModels.get(position).getImagePath());
//            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            holder.image.setImageBitmap(image);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (selectedPosition == position) {
            holder.card.setBackgroundColor(context.getResources().getColor(R.color.yellow));
            holder.card.setSelected(true);
            Log.d("aaaaaa","Aaaaaaaaaaa");
        }
        else {
            holder.card.setBackgroundColor(context.getResources().getColor(R.color.tab_color));
            holder.card.setSelected(false);
            Log.d("bbbbbbbbb","Bbbbb");
        }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition>=0)
                {
                    notifyItemChanged(selectedPosition);
                }
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);
                RecipeFragment.dataModels.clear();
                RecipeFragment.pageno=1;
                RecipeFragment.searchName = recipeModels.get(position).getName();
                RecipeFragment.Id = recipeModels.get(position).getId();
                RecipeFragment.getRecipeData(recipeModels.get(position).getName(),recipeModels.get(position).getId());

            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView mealname;
        LinearLayout card;
        LinearLayout r_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card_view_category);
            image = (ImageView)itemView.findViewById(R.id.imageview_category_image);
            mealname = (TextView)itemView.findViewById(R.id.txt_recipe_category_name);
            r_view = (LinearLayout)itemView.findViewById(R.id.linearlayout_cateogries);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyDataSetChanged();
                }
            });

        }
    }


}
