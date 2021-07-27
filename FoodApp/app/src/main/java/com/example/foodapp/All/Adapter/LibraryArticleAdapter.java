package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Models.LibraryArticleModel;
import com.example.foodapp.R;

import java.util.ArrayList;

public class LibraryArticleAdapter extends RecyclerView.Adapter<LibraryArticleAdapter.ViewHolder>{

    Context context;
    ArrayList<LibraryArticleModel> data;

    public LibraryArticleAdapter(Context context, ArrayList<LibraryArticleModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public LibraryArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_library_article, parent, false);
        return new LibraryArticleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibraryArticleAdapter.ViewHolder holder, int position) {

        LibraryArticleModel libraryArticleModel = data.get(position);
        holder.ing.setText(libraryArticleModel.getIng());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView ing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ing = (TextView) itemView.findViewById(R.id.library_article_item_ingredients);


        }
    }
}
