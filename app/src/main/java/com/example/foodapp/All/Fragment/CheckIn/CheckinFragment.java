package com.example.foodapp.All.Fragment.CheckIn;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.foodapp.All.Fragment.HomeFragment;
import com.example.foodapp.R;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class CheckinFragment extends Fragment {


    Button btn;
    LineChart mChart, mchart1;
    ImageView back;

    public CheckinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_checkin, container, false);
        btn = (Button)view.findViewById(R.id.btn_check_in);
        back = (ImageView)view.findViewById(R.id.ivback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, new HomeFragment()).addToBackStack(null).commit();

            }
        });

        mChart = view.findViewById(R.id.chart);
        mchart1 = view.findViewById(R.id.chart2);

        mChart.setTouchEnabled(false);
        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.graph_marker);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        renderDataToChart1();
        mChart.animateX(1000);
        mchart1.animateX(1000);

        mchart1.setTouchEnabled(false);
        MyMarkerView mv1 = new MyMarkerView(getContext(), R.layout.graph_marker);
        mv1.setChartView(mchart1);
        mchart1.setMarker(mv1);
        renderDataToChart2();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                CheckInFragmentHomePage myFragment = new CheckInFragmentHomePage();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, myFragment).addToBackStack(null).commit();
            }
        });
        return view;
    }


    public void renderDataToChart1() {

        XAxis xAxis = mChart.getXAxis();
        //xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum(12f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(1f);
        xAxis.setLabelCount(12,true);
        xAxis.setDrawAxisLine(false);
        xAxis.setYOffset(6);

        mchart1.getDescription().setEnabled(false);


        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaximum(70f);
        leftAxis.setAxisMinimum(10f);
        leftAxis.setSpaceMin(1f);
        leftAxis.setSpaceMax(1f);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawLimitLinesBehindData(false);

        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.getLegend().setEnabled(false);
        mChart.getDescription().setEnabled(false);


        setData();
    }

    private void setData() {

        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(1, 10));
        values.add(new Entry(2, 13));
        values.add(new Entry(3, 20));
        values.add(new Entry(4, 22));
        values.add(new Entry(5, 30));
        values.add(new Entry(7, 36));
        values.add(new Entry(8, 38));
        values.add(new Entry(12, 40));

        LineDataSet set1 = new LineDataSet(values, "Sample Data");
        set1.setLineWidth(10f);

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.setLineWidth(10f);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1.setDrawIcons(false);
            //set1.enableDashedLine(10f, 5f, 0f);
            //set1.enableDashedHighlightLine(10f, 5f, 0f);


            set1.setLineWidth(4f);
            set1.setCircleRadius(5f);

            int color = ContextCompat.getColor(getContext(), R.color.green);

            set1.setColor(color);
            set1.setCircleColor(color);

            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setHighlightLineWidth(10f);
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_blue);
                drawable.setAlpha(2);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.DKGRAY);
            }
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mChart.setData(data);
        }
    }


    public void renderDataToChart2() {

        XAxis xAxis = mchart1.getXAxis();
        //xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum(12f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(1f);
        xAxis.setLabelCount(12,true);
        xAxis.setDrawAxisLine(false);
        xAxis.setYOffset(6);

        mchart1.getDescription().setEnabled(false);
        YAxis leftAxis = mchart1.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.setAxisMaximum(60f);
        leftAxis.setAxisMinimum(10f);
        leftAxis.setSpaceMin(1f);
        leftAxis.setSpaceMax(1f);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawLimitLinesBehindData(false);

        mchart1.getAxisLeft().setDrawGridLines(true);
        mchart1.getXAxis().setDrawGridLines(false);
        mchart1.getAxisRight().setEnabled(false);
        mchart1.getLegend().setEnabled(false);




        setData2();
    }

    private void setData2() {

        ArrayList<Entry> values = new ArrayList<>();
        values.add(new Entry(1, 60));
        values.add(new Entry(2, 55));
        values.add(new Entry(3, 50));
        values.add(new Entry(4, 42));
        values.add(new Entry(5, 30));
        values.add(new Entry(7, 28));
        values.add(new Entry(8, 20));
        values.add(new Entry(12, 12));

        LineDataSet set1 = new LineDataSet(values, "Sample Data");
        set1.setLineWidth(10f);

        if (mchart1.getData() != null &&
                mchart1.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mchart1.getData().getDataSetByIndex(0);
            set1.setValues(values);
            set1.setLineWidth(10f);
            mchart1.getData().notifyDataChanged();
            mchart1.notifyDataSetChanged();
        } else {
            set1.setDrawIcons(false);
            //set1.enableDashedLine(10f, 5f, 0f);
            //set1.enableDashedHighlightLine(10f, 5f, 0f);

            set1.setLineWidth(4f);
            set1.setCircleRadius(5f);

            int color = ContextCompat.getColor(getContext(), R.color.pink);

            set1.setColor(color);
            set1.setCircleColor(color);

            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setHighlightLineWidth(10f);
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_blue);
                drawable.setAlpha(2);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.DKGRAY);
            }
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mchart1.setData(data);
        }
    }




}