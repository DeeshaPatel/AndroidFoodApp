package com.example.foodapp.All.Fragment.CheckIn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.foodapp.All.Adapter.TabFragmentAdapter;
import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.R;
import com.google.android.material.tabs.TabLayout;


public class CheckInFragmentHomePage extends Fragment {

    TabLayout mTabs;
    ViewPager mViewPager;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_check_in, container, false);


        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CheckinFragment myFragment = new CheckinFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        mTabs = view.findViewById(R.id.check_in_tablayot);
        mViewPager = view.findViewById(R.id.vptablayout);

        TabFragmentAdapter adapter = new TabFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(new BioFeedbackFragment(), "Bio Feedback");
        adapter.addFragment(new MeasurementsFragment(), "Measurements");
        adapter.addFragment(new ImagesFragment(), "Images");
        mViewPager.setAdapter(adapter);
        mTabs.setupWithViewPager(mViewPager);


        return view;

    }


}