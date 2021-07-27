package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.AddMealFoodDiary;
import com.example.foodapp.All.Fragment.LibraryArticalPage;
import com.example.foodapp.All.Fragment.LibraryHomePageFragment;
import com.example.foodapp.All.Fragment.MealPlanFragment;
import com.example.foodapp.All.Fragment.ProfileFragment;
import com.example.foodapp.All.Fragment.RecipeFragment;
import com.example.foodapp.All.Fragment.SettingFragment;
import com.example.foodapp.All.Fragment.ShoppingList;
import com.example.foodapp.All.Models.HomeRecyModel;
import com.example.foodapp.All.Fragment.CheckIn.CheckinFragment;
import com.example.foodapp.All.Fragment.FoodDiaryMainView;
import com.example.foodapp.All.Models.LibraryMainPageModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class HomeRecyAdapter extends RecyclerView.Adapter<HomeRecyAdapter.ViewHolder> {

    private Context context;
    ArrayList<HomeRecyModel> list_rectdata = new ArrayList<>();

    public HomeRecyAdapter(Context context, ArrayList<HomeRecyModel> list_rectdata) {
        this.context = context;
        this.list_rectdata = list_rectdata;
    }

    @NonNull
    @Override
    public HomeRecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_home_recy_item, parent, false);
        return new HomeRecyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecyAdapter.ViewHolder holder, final int position) {

        holder.tvitemname.setText(list_rectdata.get(position).getName());
        holder.ivitemima.setImageDrawable(ContextCompat.getDrawable(context, list_rectdata.get(position).getIma()));
        holder.llback.setBackgroundColor(Color.parseColor(list_rectdata.get(position).getColor()));

        // imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.your_image));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==7) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ProfileFragment myFragment = new ProfileFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                }
                if(position==5){
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    SettingFragment myFragment = new SettingFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                }
                if(position==4){
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    CheckinFragment myFragment = new CheckinFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

                }
                if (position==1)
                {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FoodDiaryMainView myFragment = new FoodDiaryMainView();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                }
                if (position==3)
                {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    LibraryHomePageFragment myFragment = new LibraryHomePageFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                }
                if (position==6)
                {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    ShoppingList myFragment = new ShoppingList();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
                }
                if (position==0)
                {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    MealPlanFragment myFragment = new MealPlanFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

                }
                if (position==2)
                {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    RecipeFragment myFragment = new RecipeFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_rectdata.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivitemima;
        TextView tvitemname;
        LinearLayout llback;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivitemima=itemView.findViewById(R.id.ivitemima);
            tvitemname=itemView.findViewById(R.id.tvitemname);
            llback=itemView.findViewById(R.id.llback);
            cardView = itemView.findViewById(R.id.home_profile_card_view);

        }

    }
}
