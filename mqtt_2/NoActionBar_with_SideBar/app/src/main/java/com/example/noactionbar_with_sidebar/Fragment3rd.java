package com.example.noactionbar_with_sidebar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class Fragment3rd extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3rd, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayout layout = view.findViewById(R.id.layout_correction);

        boolean chartBool = false;

        LineChart lineChart = view.findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<>();

        for(Integer i = 1; i <= 30; i++){
            //testLI
            LogItem logItem = new LogItem(getActivity());

            logItem.setChString("ch"+i);
            logItem.setValue(i+30);

            //add child
            layout.addView(logItem);

            //add chart data
            if(chartBool){
                entries.add(new Entry(i, i+1));
            }
            else {
                entries.add(new Entry(i, i-1));
            }
            chartBool = !chartBool;
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "속성명1");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);


        //실행내용
    }
}
