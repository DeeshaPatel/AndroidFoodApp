package com.example.foodapp.All.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.foodapp.All.Activitys.Notification;
import com.example.foodapp.All.Adapter.AutoSlidingPager;
import com.example.foodapp.All.Adapter.HomeRecyAdapter;
import com.example.foodapp.All.Models.HomeRecyModel;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

    RecyclerView rvitems;
    HomeRecyAdapter homeRecyAdapter;
    ArrayList<HomeRecyModel> list_rectdata = new ArrayList<>();
    ImageView notification;
    ViewPager viewPager;
    Integer[] integers = {R.drawable.slider1,R.drawable.main_page_scrolling1,R.drawable.main_page_scrolling2};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvitems = view.findViewById(R.id.rvitems);
        notification = view.findViewById(R.id.notification_homepage);

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

        rvitems.setLayoutManager(new GridLayoutManager(getActivity(), 2, RecyclerView.VERTICAL, false));
        Data();

        PagerAdapter pagerAdapter = new AutoSlidingPager(getActivity(),integers);
        viewPager.setAdapter(pagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

        return view;

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