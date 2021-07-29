package com.example.foodapp.All.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.All.Adapter.CustomCalendar_WithourDisplay_Two;
import com.example.foodapp.All.Adapter.MealPlanMainAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.Data;
import com.example.foodapp.All.Database.Service.MealPlanMealUpsertDto;
import com.example.foodapp.All.Database.Service.MealPlanModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Models.CustomCalendar;
import com.example.foodapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealPlanFragment extends Fragment {

    public static RecyclerView recyclerView;
    public static TextView protein, fats, carbs, fibre, total_cal;
    int pageno = 1;
    public ProgressDialog progressDialog;
    public static int current_date_position;
    static final long ONE_DAY = 24 * 60 * 60 * 1000L;
    RecyclerView calender;
    public static ArrayList<CustomCalendar> data1;
    ImageView back;
    public SwipeRefreshLayout swipeRefreshLayout;
    public String token="";
    public static Context context;
    public static TextView txt_no_meal_found;
    SharedPreferences sharedPreferences;
    NestedScrollView nested_scroll_view;
    public static ProgressBar progress_bar_load_new_item;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);

        calender = (RecyclerView)view.findViewById(R.id.rcv_date_day_viewer);

        protein = (TextView)view.findViewById(R.id.txt_meal_plan_total_protein);
        fats = (TextView)view.findViewById(R.id.txt_meal_plan_total_fat);
        carbs = (TextView)view.findViewById(R.id.txt_meal_plan_total_carb);
        fibre = (TextView)view.findViewById(R.id.txt_meal_plan_total_fibre);
        total_cal = (TextView)view.findViewById(R.id.txt_meal_plan_total_calories);
        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_meal_name);
        nested_scroll_view = view.findViewById(R.id.nested_scroll_view);
        progress_bar_load_new_item = view.findViewById(R.id.progress_bar_load_new_item);
        txt_no_meal_found = view.findViewById(R.id.txt_no_meal_found);

        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swiperefresh);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        calender.setLayoutManager(linearLayoutManager1);
        data1 = getDatesBetween("01/01/2021","01/01/2023");
        final CustomCalendar_WithourDisplay_Two customCalendar = new CustomCalendar_WithourDisplay_Two(getContext(),data1);
        calender.setAdapter(customCalendar);
        calender.scrollToPosition(current_date_position);


        sharedPreferences = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        context = getContext();

        mealPlanSet(token);
        nested_scroll_view.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())
                {
                    pageno++;
                    Log.d("GGGGG","Yes");
                    progress_bar_load_new_item.setVisibility(View.VISIBLE);
                    mealPlanSet(token);
                }
            }
        });


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mealPlanSet(token);
                pageno=1;
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                HomeFragment myFragment = new HomeFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


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
        Log.d("12346374876543",String.valueOf(x));

        return customCalendars;
    }

    public void mealPlanSet(String token)
    {
        if (MealPlanFragment.progress_bar_load_new_item.getVisibility()==View.GONE)
        {
            showProgress();

        }
        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);
        Log.d("Selected data should be right",CustomCalendar_WithourDisplay_Two.selectedDateForData);


        Call<MealPlanModel> call = userClient.getAllData(CustomCalendar_WithourDisplay_Two.selectedDateForData+"T11:13:53.247Z",pageno,50,token);
        call.enqueue(new Callback<MealPlanModel>() {
            @Override
            public void onResponse(Call<MealPlanModel> call, Response<MealPlanModel> response) {

                Log.d("Check Message", String.valueOf(response.body()));
                MealPlanFragment.progress_bar_load_new_item.setVisibility(View.GONE);
                progressDialog.dismiss();

                if (response.body()!=null && !response.body().getData().isEmpty())
                {
                    MealPlanFragment.recyclerView.setVisibility(View.VISIBLE);
                    MealPlanFragment.txt_no_meal_found.setVisibility(View.GONE);

                    List<Data> mealPlanMealUpsertDto = response.body().getData();
                    List<MealPlanMealUpsertDto> mealPlanMealUpsertDtos=null;
                    Log.d("lllllllll", String.valueOf((int)mealPlanMealUpsertDto.get(0).getTotalcalories()));
                    for (int i=0;i<mealPlanMealUpsertDto.size();i++)
                    {
                        MealPlanFragment.total_cal.setText(String.valueOf((int)mealPlanMealUpsertDto.get(i).getTotalcalories())+" cal");
                        MealPlanFragment.protein.setText(String.valueOf((int)mealPlanMealUpsertDto.get(i).getTotalProtein()));
                        MealPlanFragment.fats.setText(String.valueOf((int)mealPlanMealUpsertDto.get(i).getTotalFat()));
                        MealPlanFragment.carbs.setText(String.valueOf((int)mealPlanMealUpsertDto.get(i).getTotalCarb()));
                        MealPlanFragment.fibre.setText(String.valueOf((int)mealPlanMealUpsertDto.get(i).getTotalFiber()));

                        mealPlanMealUpsertDtos = mealPlanMealUpsertDto.get(i).getMealPlanMealUpsertDto();

                    }

                    ArrayList<MealPlanMealUpsertDto> data = new ArrayList(mealPlanMealUpsertDtos);

                    Log.d("JJJJJJJJ", String.valueOf(data.size()));
                    MealPlanMainAdapter mealPlanMainAdapter = new MealPlanMainAdapter(context,data);
                    LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                    MealPlanFragment.recyclerView.setLayoutManager(linearLayoutManager1);
                    MealPlanFragment.recyclerView.setAdapter(mealPlanMainAdapter);
                    MealPlanFragment.recyclerView.setNestedScrollingEnabled(false);

                    MealPlanFragment.progress_bar_load_new_item.setVisibility(View.GONE);

                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                        MealPlanFragment.progress_bar_load_new_item.setVisibility(View.GONE);
                    }

                }
                else {

                    if (pageno>=2)
                    {
                        //Toast.makeText(context,"No more Data",Toast.LENGTH_LONG).show();
                    }
                    if (pageno==1)
                    {
                        MealPlanFragment.txt_no_meal_found.setVisibility(View.VISIBLE);
                        MealPlanFragment.recyclerView.setVisibility(View.GONE);
                        //Toast.makeText(context,"No data found",Toast.LENGTH_LONG).show();
                    }
                    if (progressDialog.isShowing())
                    {
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<MealPlanModel> call, Throwable t) {
                Toast.makeText(getContext(),"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showProgress() {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Food App");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

    }

}