package com.example.foodapp.All.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodapp.R;

public class DefaultGoalDashBoard extends Fragment {

    Button button;
    Context context;

    public DefaultGoalDashBoard(Context context){
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_default_goal_dash_board, container, false);
        button = (Button)view.findViewById(R.id.btn_add_daily_goals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Add_Custom_Goal_Fragment myFragment = new Add_Custom_Goal_Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }
}