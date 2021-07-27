package com.example.foodapp.All.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.foodapp.All.Activitys.MealPlanTemplateFragment;
import com.example.foodapp.R;

public class Add_Custom_Goal_Fragment extends Fragment {

    Button b1,b2,b3,b4,b5,b6,b7;
    ImageView back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add__custom__goal_, container, false);

         back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                MealPlanTemplateFragment myFragment = new MealPlanTemplateFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });


        b1 = (Button)view.findViewById(R.id.d_b1);
        b2 = (Button)view.findViewById(R.id.d_b2);
        b3 = (Button)view.findViewById(R.id.d_b3);
        b4 = (Button)view.findViewById(R.id.d_b4);
        b5 = (Button)view.findViewById(R.id.d_b5);
        b6 = (Button)view.findViewById(R.id.d_b6);
        b7 = (Button)view.findViewById(R.id.d_b7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.green));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.green));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.green));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.green));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.green));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.green));
                b7.setBackgroundColor(getResources().getColor(R.color.grey));

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setBackgroundColor(getResources().getColor(R.color.grey));
                b2.setBackgroundColor(getResources().getColor(R.color.grey));
                b3.setBackgroundColor(getResources().getColor(R.color.grey));
                b4.setBackgroundColor(getResources().getColor(R.color.grey));
                b5.setBackgroundColor(getResources().getColor(R.color.grey));
                b6.setBackgroundColor(getResources().getColor(R.color.grey));
                b7.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });

        return view;
    }
}