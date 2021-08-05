package com.example.foodapp.All.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.All.Database.Service.GetBlogCategoryDataMode;
import com.example.foodapp.All.Fragment.LibraryHomePageFragment;
import com.example.foodapp.R;

import java.util.ArrayList;

public class LibraryHomePageHeadingAdapter extends RecyclerView.Adapter<LibraryHomePageHeadingAdapter.ViewHolder>{

    Context context;
    ArrayList<GetBlogCategoryDataMode> getBlogCategoryDataModes;
    int c_position=0;

    public LibraryHomePageHeadingAdapter(Context context, ArrayList<GetBlogCategoryDataMode> getBlogCategoryDataModes)
    {
        this.context = context;
        this.getBlogCategoryDataModes = getBlogCategoryDataModes;
    }

    @NonNull
    @Override
    public LibraryHomePageHeadingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_library_home_page_heading_content, parent, false);
        return new LibraryHomePageHeadingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LibraryHomePageHeadingAdapter.ViewHolder holder, final int position) {
        holder.textView.setText(getBlogCategoryDataModes.get(position).getBlogCategoryName());

        holder.changeColor(getBlogCategoryDataModes.get(position));

        holder.line.setVisibility(View.VISIBLE);
        if (position == 0)
        {
            holder.line.setVisibility(View.GONE);
        }
        holder. textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c_position = position;
                notifyDataSetChanged();

                if(LibraryHomePageFragment.dataModels.size()!=0)
                {
                    LibraryHomePageFragment.dataModels.clear();
                    LibraryHomePageFragment.libraryMainPageAdapter.notifyDataSetChanged();
                }
                LibraryHomePageFragment.getLibraryData(getBlogCategoryDataModes.get(position).getBlogCategoryId(),LibraryHomePageFragment.token);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getBlogCategoryDataModes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        View line;
        boolean isSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txt_library_heading_content);
            line = itemView.findViewById(R.id.view_vertical_line);


        }
        public void changeColor(GetBlogCategoryDataMode gb)
        {
            if (c_position==getAdapterPosition())
            {
                textView.setTextColor(context.getResources().getColor(R.color.yellow));
                isSelected = true;
            }
            else
            {
                textView.setTextColor(context.getResources().getColor(R.color.white));
                isSelected = false;
            }
        }
    }

}
