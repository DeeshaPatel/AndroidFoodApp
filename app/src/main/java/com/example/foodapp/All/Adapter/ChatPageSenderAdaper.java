package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ChatPageSender;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ChatPageSenderAdaper extends RecyclerView.Adapter<ChatPageSenderAdaper.ViewHolder>{

    Context context;
    ArrayList<ChatPageSender> chatPageSenders;

    public ChatPageSenderAdaper(Context context,ArrayList<ChatPageSender> chatPageSenders)
    {
        this.context = context;
        this.chatPageSenders = chatPageSenders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_sender_chat_message_design, parent, false);
        return new ChatPageSenderAdaper.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatPageSender chatPageSender = chatPageSenders.get(position);
        holder.imageView.setImageResource(chatPageSender.getId());
        holder.message.setText(chatPageSender.getMessage());
        holder.time.setText(chatPageSender.getTime());
    }

    @Override
    public int getItemCount() {
        return chatPageSenders.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView message,time;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            message = (TextView)itemView.findViewById(R.id.original_message_send);
            time = (TextView)itemView.findViewById(R.id.time_of_message_send);
            imageView = (ImageView)itemView.findViewById(R.id.image_chat_page_dp);
        }
    }

}