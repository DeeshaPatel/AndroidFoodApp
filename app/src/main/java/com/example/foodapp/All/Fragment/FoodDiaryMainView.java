package com.example.foodapp.All.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.foodapp.All.Activitys.MealPlanTemplateFragment;
import com.example.foodapp.All.Activitys.ProgressAnimation;
import com.example.foodapp.All.Adapter.CustomCalendar_withoutDisplay;
import com.example.foodapp.All.Adapter.FoodDiaryMealAdapter;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.All.Models.FoodDiaryMealModel;
import com.example.foodapp.All.Models.FoodDiaryMealSubItemModel;
import com.example.foodapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FoodDiaryMainView extends Fragment {


    RecyclerView recyclerView;
    Button nutrient,template;
    ImageView back;
    public static int current_date_position;
    static final long ONE_DAY = 24 * 60 * 60 * 1000L;
    public static RecyclerView calender;
    TextView protein, fats, carbs, fibre, total_cal;
    public static ArrayList<CustomCalendar> data;
    public static Context context;
    public String token="";
    ArrayList<FoodDiaryMealModel> models;
    ProgressBar linearProgressIndicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_main_food_diary, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_meal_name);
        nutrient = (Button) view.findViewById(R.id.btn_nutrient_goals_food_diary);
        template = (Button)view.findViewById(R.id.btn_meal_plan_template_food_diary);
        calender = (RecyclerView)view.findViewById(R.id.rcv_date_day_viewer);
        linearProgressIndicator = (ProgressBar) view.findViewById(R.id.progress_horizontal);
        protein = (TextView)view.findViewById(R.id.txt_food_diary_meal_protein);
        fats = (TextView)view.findViewById(R.id.txt_food_diary_meal_fat);
        carbs = (TextView)view.findViewById(R.id.txt_food_diary_meal_carbs);
        fibre = (TextView)view.findViewById(R.id.txt_food_diary_meal_fibre);
        total_cal = (TextView)view.findViewById(R.id.txt_food_diary_meal_total_calories);

        ProgressAnimation p1 = new ProgressAnimation(linearProgressIndicator,0,80);
        p1.setDuration(1000);
        linearProgressIndicator.startAnimation(p1);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        context = getContext();

        set_recycler();

        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                HomeFragment myFragment = new HomeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

        nutrient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FoodDiaryNutritionView();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        template.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new MealPlanTemplateFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        models = new ArrayList<>();
        models.add(new FoodDiaryMealModel("Meal 1","270 cal",R.drawable.downgreen,chileItemList()));
        models.add(new FoodDiaryMealModel("Meal 2","270 cal",R.drawable.downgreen,chileItemList()));
        models.add(new FoodDiaryMealModel("Meal 3","270 cal",R.drawable.downgreen,chileItemList()));
        models.add(new FoodDiaryMealModel("Meal 4","270 cal",R.drawable.downgreen,chileItemList()));
        models.add(new FoodDiaryMealModel("Meal 5","270 cal",R.drawable.downgreen,chileItemList()));


        FoodDiaryMealAdapter foodDiaryMealaAdapter = new FoodDiaryMealAdapter(getContext(),models);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(foodDiaryMealaAdapter);
        recyclerView.setNestedScrollingEnabled(false);




        return view;
    }

    private List<FoodDiaryMealSubItemModel> chileItemList() {
        List<FoodDiaryMealSubItemModel> foodDiaryMealSubItemModels = new ArrayList<>();
        foodDiaryMealSubItemModels.add(new FoodDiaryMealSubItemModel("Food1","120g","90g","30g","120 cal"));
        foodDiaryMealSubItemModels.add(new FoodDiaryMealSubItemModel("Food2","120g","90g","30g","120 cal"));
        foodDiaryMealSubItemModels.add(new FoodDiaryMealSubItemModel("Food3","120g","90g","30g","120 cal"));
        return foodDiaryMealSubItemModels;
    }

    public static void set_recycler()
    {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        calender.setLayoutManager(linearLayoutManager);
        data = getDatesBetween("01/01/2021","01/01/2023");
        final CustomCalendar_withoutDisplay customCalendar = new CustomCalendar_withoutDisplay(context,data);
        calender.setAdapter(customCalendar);
        calender.scrollToPosition(current_date_position);
        customCalendar.notifyDataSetChanged();
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
        Log.d("12346374876543",String.valueOf(x));

        return customCalendars;
    }

}