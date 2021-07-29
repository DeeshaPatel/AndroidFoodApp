package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.FoodDiaryNutritionView;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CustomCalendarAdapter extends RecyclerView.Adapter<CustomCalendarAdapter.ViewHolder> {

    Context context;
    ArrayList<CustomCalendar> model;
    private int selectedPosition = -1;

    int pos;

    public CustomCalendarAdapter(Context context, ArrayList<CustomCalendar> model)
    {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_calender_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final CustomCalendar foodDiaryMealModel = model.get(position);
        holder.date.setText(foodDiaryMealModel.getDate());
        holder.day.setText(foodDiaryMealModel.getDay());

        int current = FoodDiaryNutritionView.current_date_position;
        Log.d("OOOOOOOOOOOOOOo",current+3+"");
        current = current+3;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedPosition=position;
                String date = "";
                if (foodDiaryMealModel.getDate().equals("1"))
                {
                    date = foodDiaryMealModel.getDate()+"st";
                }
                else if (foodDiaryMealModel.getDate().equals("2"))
                {
                    date = foodDiaryMealModel.getDate()+"nd";
                }
                else if (foodDiaryMealModel.getDate().equals("3"))
                {
                    date = foodDiaryMealModel.getDate()+"rd";
                }
                else
                {
                    date = foodDiaryMealModel.getDate()+"th";
                }

                FoodDiaryNutritionView.textView.setText(foodDiaryMealModel.getDay()+" "+date+" "+foodDiaryMealModel.getMonth());
                notifyDataSetChanged();

            }
        });

        if (selectedPosition==position)
        {

            holder.date.setBackgroundResource(R.drawable.round_selected_date_shape);
        }
        else if (current==position)
        {
            Log.d("Called","Check");
            holder.date.setBackgroundResource(R.drawable.round_selected_date_shape_yello);
        }
        else
        {
            holder.date.setBackgroundResource(R.drawable.round_selected_date_shape_white);
        }

    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date,day;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.selct_my_date);
            date = (TextView)itemView.findViewById(R.id.txt_view_date_of_week);
            day = (TextView)itemView.findViewById(R.id.txt_view_day_of_week);


        }


    }
}
