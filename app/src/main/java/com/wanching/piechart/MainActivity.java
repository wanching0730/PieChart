package com.wanching.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int rainFall[] = {98, 123, 161};
    String month[] = {"Jan", "Feb", "Mar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupChart();

    }

    private void setupChart(){
        List<PieEntry> pieEntries = new ArrayList<>();
        for(int i = 0; i < rainFall.length; i++){
            pieEntries.add(new PieEntry(rainFall[i], month[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntries, "Rainfall for Malaysia");
        PieData data = new PieData(dataSet);
        data.setValueTextSize(40f);

        PieChart chart = (PieChart) findViewById(R.id.chart);
        chart.setData(data);
        chart.setEntryLabelTextSize(30f);
        chart.invalidate();
    }
}
