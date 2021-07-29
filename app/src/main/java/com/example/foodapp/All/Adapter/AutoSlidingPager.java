package com.example.foodapp.All.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.foodapp.R;

import java.util.List;

public class AutoSlidingPager extends PagerAdapter {

    Context context;
    Integer[] image;
    public AutoSlidingPager(Context activity,Integer[] images)
    {
        this.context = activity;
        this.image = images;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewItem = layoutInflater.inflate(R.layout.slider_image_view, container, false);
        //finding id
        ImageView imageView =  viewItem.findViewById(R.id.img_slider);
        //setting data
        imageView.setImageResource(image[position]);

        container.addView(viewItem);

        return viewItem;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
