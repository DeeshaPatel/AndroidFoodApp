package com.example.foodapp.All.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.foodapp.R;
import com.example.foodapp.All.Adapter.SplashAdapter;

public class Splash extends AppCompatActivity {

    ViewPager viewPager;
    TextView textView;
    int[] layouts = {R.layout.activity_splash,R.layout.activity_splash1,R.layout.activity_splash2};

    SplashAdapter splashAdapter;

    LinearLayout dot_layout;
    ImageView[] dots;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_viewpager);

        viewPager = (ViewPager)findViewById(R.id.vp_slider);

        splashAdapter = new SplashAdapter(layouts,this);
        viewPager.setAdapter(splashAdapter);

        dot_layout = (LinearLayout)findViewById(R.id.dotLayout);
        createdots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createdots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void createdots(int currentPosition){
        if (dot_layout!=null)
            dot_layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i=0; i<layouts.length;i++){
            dots[i] = new ImageView(this);
            if (i==currentPosition) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.slidingdots));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.defaultdot));
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(12,0,12,0);
            dot_layout.addView(dots[i],layoutParams);
        }
    }

    public void Jumpatloginpage(View view) {

        Intent i = new Intent(Splash.this, SignInActivity.class);
        startActivity(i);

    }
}
