package com.example.foodapp.All.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Adapter.ImportMealAdapter;
import com.example.foodapp.All.Models.ImportMealData;
import com.example.foodapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class BottomSheet extends BottomSheetDialogFragment {

    RecyclerView recyclerView;
    ArrayList<ImportMealData> data;

    public BottomSheet()
    {

    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(),
                R.layout.fragment_add_import_food_diary, null);
        dialog.setContentView(contentView);
        ((View) contentView.getParent()).setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_import_food_diary,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.rcv_import_data);

        View v = view.findViewById(R.id.bottom_sheet_layout);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(v);

        bottomSheetBehavior.setPeekHeight(3000);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setFitToContents(false);
        bottomSheetBehavior.setExpandedOffset(0);


        data = new ArrayList<>();
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));
        data.add(new ImportMealData(R.drawable.i6,"Meal 1","Egg","20","40","40","20"));

        ImportMealAdapter adapter = new ImportMealAdapter(getContext(),data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);

        return view;
    }
}
