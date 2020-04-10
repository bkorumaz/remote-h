package com.tigers.remote_h;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Statistics extends AppCompatActivity {
    BarChart  mChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_statistics);
        mChart=(BarChart)findViewById(R.id.chart);
        mChart.getDescription().setEnabled(false);
        setData(7);
        mChart.setFitBars(true);

    }

    private  void setData(int count)
    {
        ArrayList<BarEntry> yVals= new ArrayList<>();
        for (int i =0;i<count;i++){
            float value=(float)(Math.random()*100);
            yVals.add(new BarEntry(i,(int)value));

        }
        BarDataSet set= new BarDataSet(yVals,"Haftalık Puanlama");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);
        BarData data = new BarData(set);
        mChart.setData(data);

    }
}
