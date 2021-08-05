package com.example.foodapp.All.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodapp.All.Activitys.Notification;
import com.example.foodapp.All.Adapter.AutoSlidingPager;
import com.example.foodapp.All.Adapter.HomeRecyAdapter;
import com.example.foodapp.All.Database.Service.ApiUtils;
import com.example.foodapp.All.Database.Service.GetSliderImageDataModel;
import com.example.foodapp.All.Database.Service.GetSliderImageMainModel;
import com.example.foodapp.All.Database.Service.UserClient;
import com.example.foodapp.All.Models.HomeRecyModel;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    RecyclerView rvitems;
    HomeRecyAdapter homeRecyAdapter;
    ArrayList<HomeRecyModel> list_rectdata = new ArrayList<>();
    ImageView notification;
    ViewPager viewPager;
    SharedPreferences sharedPreferences;
    String token;
    public static String[] images_url;
    Integer[] integers = {R.drawable.slider1,R.drawable.main_page_scrolling1,R.drawable.main_page_scrolling2};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvitems = view.findViewById(R.id.rvitems);
        notification = view.findViewById(R.id.notification_homepage);

        sharedPreferences = getContext().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        token = "Bearer "+sharedPreferences.getString("token","");

        viewPager = view.findViewById(R.id.view_page_home_scrolling);

        rvitems.setNestedScrollingEnabled(false);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(),Notification.class);
                view.getContext().startActivity(i);
                getActivity().overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );
            }
        });

        mealPlanSet(token);

        rvitems.setLayoutManager(new GridLayoutManager(getActivity(), 2, RecyclerView.VERTICAL, false));
        Data();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

        return view;

    }

    public void mealPlanSet(String token)
    {
        UserClient userClient = ApiUtils.getAPIService().create(UserClient.class);

        Call<GetSliderImageMainModel> call = userClient.getSliderImage(token);
        call.enqueue(new Callback<GetSliderImageMainModel>() {
            @Override
            public void onResponse(Call<GetSliderImageMainModel> call, Response<GetSliderImageMainModel> response) {


                if (response.body()!=null && !response.body().getData().isEmpty())
                {
                    ArrayList<GetSliderImageDataModel> getSliderImageDataModels = response.body().getData();
                    images_url = new String[getSliderImageDataModels.size()];
                    for (int i=0;i<getSliderImageDataModels.size();i++)
                    {
                        images_url[i] = getSliderImageDataModels.get(i).getImageUrl();
                    }
                    PagerAdapter pagerAdapter = new AutoSlidingPager(getActivity(),images_url);
                    viewPager.setAdapter(pagerAdapter);
                    Log.d("QQQQQQQQQQQQ", String.valueOf(getSliderImageDataModels.size()));
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<GetSliderImageMainModel> call, Throwable t) {
                Toast.makeText(getContext(),"Something is wrong",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Data() {

        list_rectdata.clear();
        HomeRecyModel homeRecyModel = new HomeRecyModel("Meal Plans", "#a2e4d8", R.drawable.im1);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Food Diary", "#fbe383", R.drawable.im2);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Recipes", "#fcc2d8", R.drawable.im4);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Library", "#a2e4d8", R.drawable.im3);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Check in", "#a2e4d8", R.drawable.im1);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Settings", "#fbe383", R.drawable.im2);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Shopping List", "#fcc2d8", R.drawable.im4);
        list_rectdata.add(homeRecyModel);
        homeRecyModel = new HomeRecyModel("Profile", "#a2e4d8", R.drawable.im1);
        list_rectdata.add(homeRecyModel);
        homeRecyAdapter = new HomeRecyAdapter(getActivity(), list_rectdata);
        rvitems.setAdapter(homeRecyAdapter);




    }

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {

            if (getActivity()!=null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() == 0) {
                            viewPager.setCurrentItem(1);
                        }
                        else if(viewPager.getCurrentItem() == 1)
                        {
                            viewPager.setCurrentItem(2);
                        }
                        else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }

}