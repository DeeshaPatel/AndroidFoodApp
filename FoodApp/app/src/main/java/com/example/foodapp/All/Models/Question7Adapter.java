package com.example.foodapp.All.Models;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.R;

import java.util.ArrayList;

public class Question7Adapter extends RecyclerView.Adapter<Question7Adapter.MyViewHolder>{

    private QuestionHolder[] questionHolders;
    int last =0;

    public Question7Adapter(QuestionHolder[] questionHolders){
        this.questionHolders = questionHolders;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_for_questionaire7,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        QuestionHolder questionHolder = questionHolders[position];
        holder.data.setText(questionHolders[position].getData());

        if (last == position)
        {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#000000"));
            Typeface typeface = ResourcesCompat.getFont(holder.cardView.getContext(), R.font.opensansbold);
            holder.data.setTypeface(typeface);
            holder.data.setTextColor(Color.parseColor("#ffffff"));
            holder.cardView.setSelected(true);
        }
        else
        {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#CCFFF6"));
            Typeface typeface = ResourcesCompat.getFont(holder.cardView.getContext(), R.font.opensansregular);
            holder.data.setTypeface(typeface);
            holder.data.setTextColor(Color.parseColor("#000000"));
            holder.cardView.setSelected(false);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.cardView.isSelected())
                {
                    last = position;
                }
                if (last == position)
                {
                    notifyItemChanged(last);
                    last = RecyclerView.NO_POSITION;
                }
                else
                {
                    last = position;
                    notifyItemChanged(last);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return questionHolders.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView data;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            data = (TextView)itemView.findViewById(R.id.card_view_data);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
        }
    }
}
