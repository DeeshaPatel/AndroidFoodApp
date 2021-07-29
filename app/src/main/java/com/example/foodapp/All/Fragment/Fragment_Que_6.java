package com.example.foodapp.All.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.foodapp.All.Activitys.Questionnaire5;
import com.example.foodapp.All.Activitys.Questionnaire6;
import com.example.foodapp.All.Activitys.Questionnaire7;
import com.example.foodapp.R;

public class Fragment_Que_6 extends Fragment {

    Button rlSkip,rlNext;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_questionnaire6, container, false);
        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Questionnaire5.class);
                startActivity(i);
            }
        });

        rlNext = (Button) view.findViewById(R.id.rlNext);
        rlSkip = (Button)view.findViewById(R.id.rlSkip);

        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProfileFragment myFragment = new ProfileFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

        rlSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ProfileFragment myFragment = new ProfileFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}
