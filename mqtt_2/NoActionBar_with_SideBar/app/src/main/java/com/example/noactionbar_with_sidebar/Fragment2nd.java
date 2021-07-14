package com.example.noactionbar_with_sidebar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import im.dacer.androidcharts.LineView;

public class Fragment2nd extends Fragment {

    ArrayList<String> strList = new ArrayList();
    ArrayList<Integer> data = new ArrayList();
    ArrayList<ArrayList<Integer>> dataLists = new ArrayList();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2nd, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        strList.add("e");
        strList.add("f");
        strList.add("g");
        strList.add("h");
        data.add(36);
        data.add(35);
        data.add(35);
        data.add(38);
        data.add(36);
        data.add(35);
        data.add(35);
        data.add(38);
        dataLists.add(data);

        GridLayout layout = view.findViewById(R.id.layout_log);

        LineView lineView = view.findViewById(R.id.line_view);
        lineView.setDrawDotLine(false);
        lineView.setShowPopup(LineView.SHOW_POPUPS_MAXMIN_ONLY); //optional
        lineView.setBottomTextList(strList);
        lineView.setColorArray(new int[]{Color.GREEN});//,Color.GREEN,Color.GRAY,Color.CYAN
        lineView.setDataList(dataLists); //or lineView.setFloatDataList(floatDataLists)


        for(Integer i = 1; i <= 30; i++){
            //testLI
            LogItem logItem = new LogItem(getActivity());

            logItem.setChString("ch"+i);
            logItem.setValue(i+30);

            //add child
            layout.addView(logItem);
        }
        //실행내용
    }
}
