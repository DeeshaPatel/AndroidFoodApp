package com.example.foodapp.All.Fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.foodapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddImportFoodDiary extends BottomSheetDialogFragment {

    public static LinearLayout linear_back, import_from_other_dates,l1;
    ImageView back;
    Button cardView;
    FrameLayout layout;
    public static Context context;
    public static int number;

    DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.custom_bottom_sheet, container, false);

        cardView = (Button)view.findViewById(R.id.btn_back_to_food_Diary);
        layout = (FrameLayout)view.findViewById(R.id.frame_layout_load_data_of_import_date);

        context = getContext();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FoodDiaryMainView myFragment = new FoodDiaryMainView();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

        linear_back = (LinearLayout)view.findViewById(R.id.ln_check_it);
        linear_back.setEnabled(false);
        l1 = (LinearLayout)view.findViewById(R.id.ln_bottom_sheet_main_layout);


        import_from_other_dates = (LinearLayout)view.findViewById(R.id.linearlayout_import_from_other_dates);
        import_from_other_dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = 1;
                FoodDiaryMainView.calender.suppressLayout(false);
                l1.setBackgroundColor(Color.parseColor("#0000ffff"));
            }
        });

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Import_Data_Recycler_view_Fragment myFragment = new Import_Data_Recycler_view_Fragment();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_load_data_of_import_date, myFragment).addToBackStack(null).commit();


        return view;
    }

    public static void changeState()
    {
        l1.setBackgroundColor(Color.parseColor("#CC494949"));
        FoodDiaryMainView.calender.suppressLayout(true);
    }
}