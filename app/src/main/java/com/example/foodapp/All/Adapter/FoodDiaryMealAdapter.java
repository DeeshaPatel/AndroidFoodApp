package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.AddMealFoodDiary;
import com.example.foodapp.All.Models.FoodDiaryMealModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class FoodDiaryMealAdapter extends RecyclerView.Adapter<FoodDiaryMealAdapter.ViewHolder>{

    Context context;
    ArrayList<FoodDiaryMealModel> model;
    RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
    private static int currentPosition = 0;


    public FoodDiaryMealAdapter(Context context, ArrayList<FoodDiaryMealModel> model){
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_food_diary_main_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        FoodDiaryMealModel foodDiaryMealModel = model.get(position);
        holder.name.setText(foodDiaryMealModel.getName());
        holder.cal.setText(foodDiaryMealModel.getCal());
        holder.imageView.setImageResource(foodDiaryMealModel.getImage());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(foodDiaryMealModel.getItemModels().size());

        FoodDiaryMealSubAdapter subAdapter = new FoodDiaryMealSubAdapter(context,foodDiaryMealModel.getItemModels());
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(subAdapter);
        holder.recyclerView.setRecycledViewPool(recycledViewPool);

        if (currentPosition == position)
        {
            if (holder.linearLayout_data.getVisibility()==View.VISIBLE)
            {
                holder.linearLayout_data.setVisibility(View.GONE);
                holder.imageView.setImageResource(R.drawable.downgreen);
            }
            else {
                holder.linearLayout_data.setVisibility(View.VISIBLE);
                holder.imageView.setImageResource(R.drawable.upgreen);
            }
        }
        holder.linearLayout_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPosition = position;
                notifyDataSetChanged();
            }
        });

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                AddMealFoodDiary myFragment = new AddMealFoodDiary();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,cal,add;
        ImageView imageView;
        RecyclerView recyclerView;
        LinearLayout linearLayout_data,linearLayout_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.rcv_txt_meal_name);
            cal = (TextView)itemView.findViewById(R.id.rcv_txt_meal_cal);
            add = (TextView)itemView.findViewById(R.id.txt_add_food);
            imageView = (ImageView)itemView.findViewById(R.id.rcv_img_up_or_down);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.rcv_nested_view);
            linearLayout_data = itemView.findViewById(R.id.linearlayout_expland_food_diary_data);
            linearLayout_title = itemView.findViewById(R.id.linearlayout_expland_food_diary_data_title);
        }
    }


}

