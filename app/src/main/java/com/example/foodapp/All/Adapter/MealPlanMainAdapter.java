package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.MealPlanMealIngredientUpsertDto;
import com.example.foodapp.All.Database.Service.MealPlanMealUpsertDto;
import com.example.foodapp.All.Fragment.MealPlanDetailsFragment;
import com.example.foodapp.R;

import java.util.ArrayList;

public class MealPlanMainAdapter extends RecyclerView.Adapter<MealPlanMainAdapter.ViewHolder>{

    Context context;
    ArrayList<MealPlanMealUpsertDto> model;
    RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

    public MealPlanMainAdapter(Context context, ArrayList<MealPlanMealUpsertDto> model){
        this.context = context;
        this.model = model;
    }

//    public FoodDiaryMealAdapter(ArrayList<MealPlanModel> model1, Context context){
//        this.context = context;
//        this.model1 = model1;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_meal_data, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        MealPlanMealUpsertDto foodDiaryMealModel= model.get(position);
        holder.name.setText(model.get(position).getMealName());
        Log.d("AAAAAAA", String.valueOf(model.size()));
        //holder.imageView.setImageResource(foodDiaryMealModel.getImage());

        final ArrayList<MealPlanMealIngredientUpsertDto> subAdapters = foodDiaryMealModel.getMealPlanMealIngredientUpsertDto();

        Log.d("HHHHHHHH", String.valueOf(subAdapters.size()));

        MealPlanSubAdapter foodDiaryMealAdapter = new MealPlanSubAdapter(context,subAdapters);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerView.setLayoutManager(linearLayoutManager1);
        holder.recyclerView.setAdapter(foodDiaryMealAdapter);
        holder.recyclerView.setNestedScrollingEnabled(false);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
//        FoodDiaryMealSubAdapter subAdapter = new FoodDiaryMealSubAdapter(context,model.get(position).getMealPlanMealIngredientUpsertDto());
//        holder.recyclerView.setLayoutManager(layoutManager);
//        holder.recyclerView.setAdapter(subAdapter);
//        holder.recyclerView.setRecycledViewPool(recycledViewPool);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                MealPlanDetailsFragment myFragment = new MealPlanDetailsFragment(model.get(position).getMealName(),model.get(position).getNotes(),subAdapters);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (holder.list.getVisibility() == View.VISIBLE)
//                {
//                    TransitionManager.beginDelayedTransition(holder.cardView,
//                            new AutoTransition());
//                    holder.list.setVisibility(View.GONE);
//                    holder.name.setTextColor(Color.parseColor("#000000"));
//                    holder.line.setBackgroundColor(Color.parseColor("#000000"));
//                    holder.imageView.setImageResource(R.drawable.down);
//
//                }
//                else
//                {
//                    TransitionManager.beginDelayedTransition(holder.cardView,
//                            new AutoTransition());
//                    holder.list.setVisibility(View.VISIBLE);
//                    holder.name.setTextColor(Color.parseColor("#A2E4D8"));
//                    holder.line.setBackgroundColor(Color.parseColor("#A2E4D8"));
//                    holder.imageView.setImageResource(R.drawable.traingle);
//
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView imageView;
        RecyclerView recyclerView;
        LinearLayout cardView,list;
        View line;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.rcv_txt_meal_name);
            line = (View) itemView.findViewById(R.id.base_line);
            cardView = (LinearLayout) itemView.findViewById(R.id.card_view_expandable);
            list = (LinearLayout)itemView.findViewById(R.id.ln_exapand);
            imageView = (ImageView)itemView.findViewById(R.id.rcv_img_up_or_down);
            recyclerView = (RecyclerView)itemView.findViewById(R.id.rcv_nested_view);
        }
    }


}
