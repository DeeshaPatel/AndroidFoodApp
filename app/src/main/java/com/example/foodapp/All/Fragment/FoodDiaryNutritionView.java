package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.foodapp.All.Activitys.ProgressAnimation;
import com.example.foodapp.All.Adapter.CustomCalendarAdapter;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FoodDiaryNutritionView extends Fragment{

    ProgressBar fat,protein,carb,fibre;
    public static int current_date_position;
    ImageView back;
    public static TextView textView;
    static final long ONE_DAY = 24 * 60 * 60 * 1000L;
    RecyclerView recyclerView;
    public static ArrayList<CustomCalendar> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_diary_nutrition_view, container, false);
        fat = (ProgressBar)view.findViewById(R.id.progress_bar_fat);
        protein = (ProgressBar)view.findViewById(R.id.progress_bar_protein);
        carb = (ProgressBar)view.findViewById(R.id.progress_bar_carbs);
        fibre = (ProgressBar)view.findViewById(R.id.progress_bar_fiber);
        textView = (TextView)view.findViewById(R.id.txt_show_date);
 //       horizontalPicker= (HorizontalPicker)view.findViewById(R.id.horizontal_date_day_picker);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_date_day_viewer);

//        horizontalPicker.setListener(this)
//            .setDays(365)
//            .setOffset(7)
//                .setDateSelectedColor(getResources().getColor(R.color.yellow))
//            .setTodayDateBackgroundColor(getResources().getColor(R.color.pink))
//            .setDayOfWeekTextColor(getResources().getColor(R.color.green))
//                .setDateSelectedTextColor(getResources().getColor(R.color.colorblack))
//            .showTodayButton(false)
//                .setMonthAndYearTextColor(getResources().getColor(R.color.light_white))
//            .init();
//        horizontalPicker.setDate(new DateTime());
//        horizontalPicker.setPadding(5,10,5,10);


//        horizontalCalendarView = (HorizontalCalendarView)view.findViewById(R.id.horizontal_date_day);
//        horizontalCalendarView.onDateDayPicked(new Event.OnDateClickEvent(new DateTime()));
//        horizontalCalendarView.setDatePickedListener(new OnDatePickedListener() {
//            @Override
//            public void OnDatePicked(Date date) {
//                Toast.makeText(getContext(),"Hello",Toast.LENGTH_LONG).show();
//                String[] strDays = new String[] { "Monday", "Tuesday","Wednesday", "Thursday","Friday", "Saturday","Sunday" };
//                SimpleDateFormat monthParse = new SimpleDateFormat("MM");
//                SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
//
//                textView.setText(date.getDay()+" "+date.getDate()+" "+date.getMonth());
//
//            }
//        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        data = getDatesBetween("01/01/2021","01/01/2023");
        CustomCalendar foodDiaryMealModel = data.get(FoodDiaryNutritionView.current_date_position+3);
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
        textView.setText(foodDiaryMealModel.getDay()+" "+date+" "+foodDiaryMealModel.getMonth());
        final CustomCalendarAdapter customCalendar = new CustomCalendarAdapter(getContext(),data);
        recyclerView.setAdapter(customCalendar);
        recyclerView.scrollToPosition(current_date_position);

        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FoodDiaryMainView myFragment = new FoodDiaryMainView();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        ProgressAnimation p1 = new ProgressAnimation(fat,0,50);
        p1.setDuration(1000);
        fat.startAnimation(p1);

        ProgressAnimation p2 = new ProgressAnimation(protein,0,70);
        p2.setDuration(1000);
        protein.startAnimation(p2);

        ProgressAnimation p3 = new ProgressAnimation(carb,0,80);
        p3.setDuration(1000);
        carb.startAnimation(p3);

        ProgressAnimation p4 = new ProgressAnimation(fibre,0,10);
        p4.setDuration(1000);
        fibre.startAnimation(p4);


        return view;
    }



    public static ArrayList<CustomCalendar> getDatesBetween(String startDate,String endDate) {

        ArrayList<CustomCalendar> customCalendars = new ArrayList<>();
        String[] strDays = new String[] { "","Sunday","Monday", "Tuesday","Wednesday", "Thursday","Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdf = new SimpleDateFormat("MM");

        String cur_date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        Log.d("Current date",cur_date);

        long  from=Date.parse(startDate);
        long to=Date.parse(endDate);

        long l_cur_date = System.currentTimeMillis();

        int x = 0;

        while(from <= to) {

            calendar.setTime(new Date(from));

            int date = new Date(from).getDate();
            String day = strDays[calendar.get(Calendar.DAY_OF_WEEK)];
            String month =month_date.format(calendar.getTime());
            String year = String.valueOf(calendar.get(Calendar.YEAR));

            String m = sdf.format(from);

            String new_date = calendar.get(Calendar.YEAR)+"-"+m+"-"+(calendar.get(Calendar.DATE)<10?("0"+calendar.get(Calendar.DATE)):(calendar.get(Calendar.DATE)));


            if (cur_date.equalsIgnoreCase(new_date))
            {
                current_date_position=x-3;
            }
            x = x +1;

            Log.d ("DATEEEEE","Dates  : "+new_date);
            Log.d("Check it",date+" "+day+" "+month+" "+year);
            customCalendars.add(new CustomCalendar(String.valueOf(date),day,month,year));
            from += ONE_DAY;
        }
        Log.d("CCCCCCCCCCCCCCCCCCCCCCCC",String.valueOf(x));

        return customCalendars;
    }

}