package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ChatPageReceiver;
import com.example.foodapp.All.Models.ChatPageSender;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ChatPageReceiverAdaper extends RecyclerView.Adapter<ChatPageReceiverAdaper.ViewHolder>{

    Context context;
    ArrayList<ChatPageReceiver> chatPageSenders;

    public ChatPageReceiverAdaper(Context context, ArrayList<ChatPageReceiver> chatPageSenders)
    {
        this.context = context;
        this.chatPageSenders = chatPageSenders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_receiver_chat_message_design, parent, false);
        return new ChatPageReceiverAdaper.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatPageReceiver chatPageSender = chatPageSenders.get(position);
        holder.message.setText(chatPageSender.getMessage());
        holder.time.setText(chatPageSender.getTime());
    }

    @Override
    public int getItemCount() {
        return chatPageSenders.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView message,time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            message = (TextView)itemView.findViewById(R.id.original_message_send);
            time = (TextView)itemView.findViewById(R.id.time_of_message_send);
        }
    }

}