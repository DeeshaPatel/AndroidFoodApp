package com.example.foodapp.All.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.foodapp.All.Adapter.ProfileTabFragmentAdapter;
import com.example.foodapp.All.Adapter.TabFragmentAdapter;
import com.example.foodapp.All.Fragment.CheckIn.CheckinFragment;
import com.example.foodapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    ImageView ivprofile;
    TabLayout tabLayout;
    FrameLayout viewPager;
    ArrayList<Fragment> fragments;
    Context context;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        ivprofile=view.findViewById(R.id.ivprofile);
        viewPager = view.findViewById(R.id.viewager_user_profile);

        ivprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = new PersonalDetailsFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.framelayout, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        fragment = new Profile_PersonalFragment(getActivity().getApplicationContext());
        fragmentManager = getChildFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewager_user_profile, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();


        tabLayout = (TabLayout)view.findViewById(R.id.tab_profile);
        tabLayout.getTabAt(2).setCustomView(R.layout.custom_tab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                        fragment = new Profile_PersonalFragment(getActivity().getApplicationContext());
                        FragmentManager fm = getChildFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.viewager_user_profile, fragment);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft.commit();
                        break;
                    case 1:
                        fragment = new Profile_Food_and_Beverage_Fragment(getActivity().getApplicationContext());
                        FragmentManager fm1 = getChildFragmentManager();
                        FragmentTransaction ft1 = fm1.beginTransaction();
                        ft1.replace(R.id.viewager_user_profile, fragment);
                        ft1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        ft1.commit();
                        break;
                    case 2:
                        AppCompatActivity activity = (AppCompatActivity) getContext();
                        DefaultGoalDashBoard myFragment = new DefaultGoalDashBoard(getActivity().getApplicationContext());
                        activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        fragments = new ArrayList<>();
//
//        fragments.add(new Profile_PersonalFragment(getActivity().getApplicationContext()));
//        fragments.add(new Profile_Food_and_Beverage_Fragment(getActivity().getApplicationContext()));
//        fragments.add(new DefaultGoalDashBoard(getActivity().getApplicationContext()));
//
//        ProfileTabFragmentAdapter pagerAdapter = new ProfileTabFragmentAdapter(getChildFragmentManager(),getContext(),fragments);
//        viewPager.setAdapter(pagerAdapter);
//
//
//
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setText("Profile");
//        tabLayout.getTabAt(1).setText("Food & Beverage");
//        tabLayout.getTabAt(2).setText("Custom Goals");

        return view;

    }


}