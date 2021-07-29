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
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Activitys.Questionnaire5;
import com.example.foodapp.All.Models.Question7Adapter;
import com.example.foodapp.All.Models.QuestionHolder;
import com.example.foodapp.R;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class Fragment_Que_7 extends Fragment {

    Button rlSkip,rlNext;
    RecyclerView rvProtein,rvGrains,rvFruits;
    ImageView back;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_questionnaire7, container, false);
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

        rvProtein = (RecyclerView)view.findViewById(R.id.rvProtein);
        QuestionHolder[] questionHolders = new QuestionHolder[]{
                new QuestionHolder("Beef"),
                new QuestionHolder("Chicken"),
                new QuestionHolder("Turkey"),
                new QuestionHolder("Pork"),
                new QuestionHolder("Ham"),
                new QuestionHolder("Bacon"),
                new QuestionHolder("Kangaroo"),
                new QuestionHolder("Tuna"),
                new QuestionHolder("Egg"),
                new QuestionHolder("Egg whites"),
                new QuestionHolder("Fish-white"),
                new QuestionHolder("Salmon"),
                new QuestionHolder("Calamari"),
                new QuestionHolder("Prawns"),
                new QuestionHolder("Steak"),
                new QuestionHolder("Lamb"),
                new QuestionHolder("Legumes"),
                new QuestionHolder("Tofu"),
                new QuestionHolder("Beef Mince"),
                new QuestionHolder("Chicken Mince"),
                new QuestionHolder("Pork Mince"),
                new QuestionHolder("Turkey Mince"),


        };
        Question7Adapter questionAdapter = new Question7Adapter(questionHolders);
        rvProtein.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        rvProtein.setLayoutManager(layoutManager);
        rvProtein.setAdapter(questionAdapter);

        rvGrains = (RecyclerView)view.findViewById(R.id.rvGrains);
        QuestionHolder[] questionHolders1 = new QuestionHolder[]{
                new QuestionHolder("Bread"),
                new QuestionHolder("Wraps"),
                new QuestionHolder("Pasta"),
                new QuestionHolder("Rice"),
                new QuestionHolder("Rice cakes"),
                new QuestionHolder("Vita weats"),
                new QuestionHolder("Oats"),
                new QuestionHolder("Muesli"),
                new QuestionHolder("Granola"),
                new QuestionHolder("English Muffins"),
                new QuestionHolder("Crumpets"),
                new QuestionHolder("Bagels"),
                new QuestionHolder("Crackers"),
                new QuestionHolder("Cereal"),
                new QuestionHolder("Pasta"),
                new QuestionHolder("Egg Noodles"),
                new QuestionHolder("Rice Noodles"),
                new QuestionHolder("Soba Noodles"),


        };
        Question7Adapter questionAdapter1 = new Question7Adapter(questionHolders1);
        rvGrains.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager1 = new FlexboxLayoutManager(getContext());
        layoutManager1.setFlexDirection(FlexDirection.ROW);
        layoutManager1.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager1.setAlignItems(AlignItems.FLEX_START);
        rvGrains.setLayoutManager(layoutManager1);
        rvGrains.setAdapter(questionAdapter1);

        rvFruits = (RecyclerView)view.findViewById(R.id.rvFruits);
        QuestionHolder[] questionHolders2 = new QuestionHolder[]{
                new QuestionHolder("Cucumber"),
                new QuestionHolder("Tomato"),
                new QuestionHolder("Lettuce"),
                new QuestionHolder("Onion"),
                new QuestionHolder("Garlic"),
                new QuestionHolder("Mushroom"),
                new QuestionHolder("Orange"),
                new QuestionHolder("Madarin"),
                new QuestionHolder("Rocket"),
                new QuestionHolder("Spinach"),
                new QuestionHolder("Peas"),
                new QuestionHolder("Corn"),
                new QuestionHolder("Apples"),
                new QuestionHolder("Peach"),
                new QuestionHolder("Grapes"),
                new QuestionHolder("Carrot"),
                new QuestionHolder("Watermelon"),
                new QuestionHolder("Dates"),


        };
        Question7Adapter questionAdapter2 = new Question7Adapter(questionHolders2);
        rvFruits.setHasFixedSize(true);
        FlexboxLayoutManager layoutManager2 = new FlexboxLayoutManager(getContext());
        layoutManager2.setFlexDirection(FlexDirection.ROW);
        layoutManager2.setJustifyContent(JustifyContent.FLEX_START);
        layoutManager2.setAlignItems(AlignItems.FLEX_START);
        rvFruits.setLayoutManager(layoutManager2);
        rvFruits.setAdapter(questionAdapter2);



        return view;
    }
}
