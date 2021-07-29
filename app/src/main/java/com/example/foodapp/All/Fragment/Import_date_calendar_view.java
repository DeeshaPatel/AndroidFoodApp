package com.example.foodapp.All.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.foodapp.All.Adapter.CustomCalendar_withoutDisplay;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Fragment.Import_Data_Recycler_view_Fragment;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Import_date_calendar_view extends Fragment {

    public static DatePicker datePicker;
    TextView textView;
    public static int selected_position;

    static final long ONE_DAY = 24 * 60 * 60 * 1000L;
    public static ArrayList<CustomCalendar> data;
    public  static boolean check = false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_import_date_calendar_view, container, false);
        datePicker = (DatePicker)view.findViewById(R.id.calender_view_select_date);
        textView = (TextView)view.findViewById(R.id.txt_select_my_date);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                check = true;
                data = getDatesBetween("01/01/2021","01/01/2023");
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(FoodDiaryMainView.context, LinearLayoutManager.HORIZONTAL, false);
                FoodDiaryMainView.calender.setLayoutManager(linearLayoutManager);
                final CustomCalendar_withoutDisplay customCalendar = new CustomCalendar_withoutDisplay(FoodDiaryMainView.context,data);
                FoodDiaryMainView.calender.setAdapter(customCalendar);
                FoodDiaryMainView.calender.scrollToPosition(FoodDiaryMainView.current_date_position);
                customCalendar.notifyDataSetChanged();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Import_Data_Recycler_view_Fragment myFragment = new Import_Data_Recycler_view_Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_load_data_of_import_date, myFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }

    public static ArrayList<CustomCalendar> getDatesBetween(String startDate, String endDate) {

        ArrayList<CustomCalendar> customCalendars = new ArrayList<>();
        String[] strDays = new String[] { "","Sunday","Monday", "Tuesday","Wednesday", "Thursday","Friday", "Saturday"};
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
        SimpleDateFormat sdf = new SimpleDateFormat("MM");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = new Date();
        formatter.format(date1);

        String m1 = String.valueOf(datePicker.getMonth()+1);
        if (datePicker.getMonth()<10)
        {
            m1 = 0 + m1;
        }

        String cur_date = datePicker.getYear()+"-"+m1+"-"+datePicker.getDayOfMonth();
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
            String my_date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

            String new_date = calendar.get(Calendar.YEAR)+"-"+m+"-"+(calendar.get(Calendar.DATE)<10?("0"+calendar.get(Calendar.DATE)):(calendar.get(Calendar.DATE)));
            Log.d("LLLLLLLLLLLLL",cur_date+"");
            Log.d("MMMMMMMMMMMMM",new_date);


            if (cur_date.equalsIgnoreCase(new_date))
            {
                selected_position=x;
                Log.d("NNNNNNNN",selected_position+"");
            }
            x = x +1;

            Log.d ("DATEEEEE","Dates  : "+new_date);
            Log.d("Check it",date+" "+day+" "+month+" "+year);
            customCalendars.add(new CustomCalendar(String.valueOf(date),day,month,year));
            from += ONE_DAY;
        }
        Log.d("12346374876543",String.valueOf(x));

        return customCalendars;
    }

}