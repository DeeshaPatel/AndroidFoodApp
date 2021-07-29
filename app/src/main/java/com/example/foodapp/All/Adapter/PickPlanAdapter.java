package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Activitys.MealPlanTemplateFragment;
import com.example.foodapp.All.Fragment.Add_Custom_Goal_Fragment;
import com.example.foodapp.All.Fragment.DefaultGoalDashBoard;
import com.example.foodapp.All.Fragment.ProfileFragment;
import com.example.foodapp.All.Models.NotificationModel;
import com.example.foodapp.All.Models.PickYourPlanModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class PickPlanAdapter extends RecyclerView.Adapter<PickPlanAdapter.ViewHolder>{

    Context context;
    ArrayList<PickYourPlanModel> pickYourPlanModels;

    public PickPlanAdapter(Context context, ArrayList<PickYourPlanModel> pickYourPlanModels)
    {
        this.context = context;
        this.pickYourPlanModels = pickYourPlanModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pick_your_plan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PickYourPlanModel model = pickYourPlanModels.get(position);
        holder.cat.setText(model.getCat());
        holder.pro.setText(model.getPro());
        holder.cal.setText(model.getCal());
        holder.fat.setText(model.getFat());
        holder.carb.setText(model.getCarb());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                DefaultGoalDashBoard myFragment = new DefaultGoalDashBoard(v.getContext());
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pickYourPlanModels.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView cat, pro, cal, fat, carb;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cat = (TextView) itemView.findViewById(R.id.pick_plan_name);
            pro = (TextView) itemView.findViewById(R.id.pick_plan_protain);
            cal = (TextView) itemView.findViewById(R.id.pick_plan_cal);
            fat = (TextView) itemView.findViewById(R.id.pick_plan_fat);
            carb = (TextView) itemView.findViewById(R.id.pick_plan_carbs);

            imageView = (ImageView) itemView.findViewById(R.id.pick_plan_add);

        }
    }
}
