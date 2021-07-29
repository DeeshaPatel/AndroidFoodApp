package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ChatAppHeadModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ChatAppHead extends RecyclerView.Adapter<ChatAppHead.ViewHolder>{

    Context context;
    ArrayList<ChatAppHeadModel> models;

    public ChatAppHead(Context context, ArrayList<ChatAppHeadModel> chatAppHeadModels)
    {
        this.context = context;
        this.models = chatAppHeadModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_chat_app_home_page_upper_list_view, parent, false);
        return new ChatAppHead.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        ChatAppHeadModel chatAppHeadModel = models.get(position);
        holder.imageView.setImageResource(chatAppHeadModel.getId());
        holder.imageView.setBackgroundColor(context.getResources().getColor(chatAppHeadModel.getColor()));
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(chatAppHeadModel.getColor()));

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0)
                {
                    Toast.makeText(holder.imageView.getContext(),"Search option",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.view2);
            imageView = (ImageView)itemView.findViewById(R.id.imageView1);
        }
    }

}
