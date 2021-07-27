package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.AddImportFoodDiary;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CustomCalendar_withoutDisplay extends RecyclerView.Adapter<CustomCalendar_withoutDisplay.ViewHolder>{


    Context context;
    ArrayList<CustomCalendar> model;
    private int selectedPosition = -1;
    public static int check_for = 0;
    public static String selectedDateForData="";


    public CustomCalendar_withoutDisplay(Context context, ArrayList<CustomCalendar> model)
    {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public CustomCalendar_withoutDisplay.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_calender_design, parent, false);
        return new CustomCalendar_withoutDisplay.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomCalendar_withoutDisplay.ViewHolder holder, final int position) {
        final CustomCalendar foodDiaryMealModel = model.get(position);
        holder.date.setText(foodDiaryMealModel.getDate());
        holder.day.setText(foodDiaryMealModel.getDay());


        int current = FoodDiaryMainView.current_date_position;
        Log.d("OOOOOOOOOOOOOOo",current+3+"");
        current = current+3;

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date simpleDateFormat = null;
                try {
                    simpleDateFormat = new SimpleDateFormat("MMMM").parse(foodDiaryMealModel.getMonth());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(simpleDateFormat);
                int month = cal.get(Calendar.MONTH)+1;
                Log.d("SSSSSSSSSSSSSSSSSSSSS",foodDiaryMealModel.getYear()+"-"+(month<10?("0"+month):(month))+"-"+foodDiaryMealModel.getDate());
                selectedDateForData = foodDiaryMealModel.getYear()+"-"+(month<10?("0"+month):(month))+"-"+foodDiaryMealModel.getDate();

                selectedPosition= position;
                notifyDataSetChanged();
                if (AddImportFoodDiary.number==1)
                {
                    AddImportFoodDiary.changeState();
                }

            }
        });


        if (selectedPosition==position)
        {
            holder.date.setBackgroundResource(R.drawable.round_selected_date_shape);

        }
//        else if (current==position)
//        {
//            holder.date.setBackgroundResource(R.drawable.round_selected_date_shape_yello);
//        }
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
