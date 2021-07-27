package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.ProteinModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class ProteinAdapter extends RecyclerView.Adapter<ProteinAdapter.Viewholder> {

    Context context;
    ArrayList<ProteinModel>list_Protein=new ArrayList<>();

    public ProteinAdapter(Context context, ArrayList<ProteinModel> list_Protein) {
        this.context = context;
        this.list_Protein = list_Protein;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tvitemname;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvitemname=itemView.findViewById(R.id.tvitemname);
        }
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.layout_protein,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.tvitemname.setText(list_Protein.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list_Protein.size();
    }


}
