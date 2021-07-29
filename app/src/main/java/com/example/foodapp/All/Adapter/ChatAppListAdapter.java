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

import com.example.foodapp.All.Fragment.AddImportFoodDiary;
import com.example.foodapp.All.Fragment.ChatPage;
import com.example.foodapp.All.Models.ChatAppListModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ChatAppListAdapter extends RecyclerView.Adapter<ChatAppListAdapter.ViewHolder> {

    Context context;
    ArrayList<ChatAppListModel> chatAppListModels;

    public ChatAppListAdapter(Context context, ArrayList<ChatAppListModel> chatAppListModels) {
        this.context = context;
        this.chatAppListModels = chatAppListModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_chat_list, parent, false);
        return new ChatAppListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatAppListModel chatAppListModel = chatAppListModels.get(position);
        holder.imageView.setImageResource(chatAppListModel.getId());
        holder.imageView.setBackgroundColor(context.getResources().getColor(chatAppListModel.getBackground()));
        holder.name.setText(chatAppListModel.getName());
        holder.lastmessage.setText(chatAppListModel.getLastMessage());
        holder.time.setText(chatAppListModel.getTime());
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(chatAppListModel.getBackground()));
        holder.fullcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                ChatPage myFragment = new ChatPage();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return chatAppListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,lastmessage,time;
        CardView cardView,fullcardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.card_list_person_profile);
            fullcardview = (CardView)itemView.findViewById(R.id.card_view_chat_list);
            imageView = (ImageView)itemView.findViewById(R.id.imageView1);
            name = (TextView)itemView.findViewById(R.id.chat_list_person_name);
            lastmessage = (TextView)itemView.findViewById(R.id.chat_list_person_last_message);
            time = (TextView)itemView.findViewById(R.id.chat_list_last_message_time);
        }
    }
}