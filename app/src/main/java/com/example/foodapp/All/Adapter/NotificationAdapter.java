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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Activitys.Notification;
import com.example.foodapp.All.Models.LibraryFoodModel;
import com.example.foodapp.All.Models.NotificationModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{

    Context context;
    ArrayList<NotificationModel> notificationModels;

    public NotificationAdapter(Context context, ArrayList<NotificationModel> notificationModels){
        this.context = context;
        this.notificationModels = notificationModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_notification, parent, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        NotificationModel model = notificationModels.get(position);
        holder.title.setText(model.getN_title());
        holder.des.setText(model.getN_des());
        holder.time.setText(model.getN_date());
        holder.imageView.setImageResource(model.getId());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.cardView.setBackgroundColor(Color.parseColor("#F1F3FB"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,des,time;
        ImageView imageView;
        LinearLayout cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (LinearLayout) itemView.findViewById(R.id.card_view_notification);
            title = (TextView) itemView.findViewById(R.id.notification_title);
            des = (TextView)itemView.findViewById(R.id.notification_details);
            time = (TextView)itemView.findViewById(R.id.notification_time);
            imageView = (ImageView)itemView.findViewById(R.id.image_view_notification);

        }
    }

}
