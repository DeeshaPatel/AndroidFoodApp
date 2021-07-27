package com.example.foodapp.All.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.foodapp.All.Adapter.NotificationAdapter;
import com.example.foodapp.All.Models.NotificationModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<NotificationModel> notificationModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView = (RecyclerView)findViewById(R.id.rcv_notification);

        notificationModels = new ArrayList<>();
        notificationModels.add(new NotificationModel(R.drawable.im3,"your food added","The description of your notification goes here. Your food is successfully added","12:30"));
        notificationModels.add(new NotificationModel(R.drawable.im3,"your food added","The description of your notification goes here. Your food is successfully added","12:30"));
        notificationModels.add(new NotificationModel(R.drawable.im3,"your food added","The description of your notification goes here. Your food is successfully added","12:30"));
        notificationModels.add(new NotificationModel(R.drawable.im3,"your food added","The description of your notification goes here. Your food is successfully added","12:30"));
        notificationModels.add(new NotificationModel(R.drawable.im3,"your food added","The description of your notification goes here. Your food is successfully added","12:30"));

        NotificationAdapter notificationAdapter = new NotificationAdapter(Notification.this,notificationModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Notification.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notificationAdapter);

    }
}