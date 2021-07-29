package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.All.Fragment.LibraryArticalPage;
import com.example.foodapp.All.Models.LibraryMainPageModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class LibraryMainPageAdapter extends RecyclerView.Adapter<LibraryMainPageAdapter.ViewHolder>{

    Context context;
    ArrayList<LibraryMainPageModel> models;

    public LibraryMainPageAdapter(Context context, ArrayList<LibraryMainPageModel> models)
    {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_library_home_page, parent, false);
        return new LibraryMainPageAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        LibraryMainPageModel libraryMainPageModel = models.get(position);
        holder.name.setText(libraryMainPageModel.getName());
        holder.image.setImageResource(libraryMainPageModel.getId());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                LibraryArticalPage myFragment = new LibraryArticalPage();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView image;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.txt_library_meal_name);
            image = (ImageView)itemView.findViewById(R.id.img_library_meal_photo);
            cardView = (CardView)itemView.findViewById(R.id.card_library_meal);

        }
    }

}
