package com.example.noactionbar_with_sidebar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fragment1st extends Fragment {

    Integer count = 0;

    ArrayList idList = new ArrayList();



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1st, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GridLayout layout = view.findViewById(R.id.layout_live);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams test = layout.getLayoutParams();

        for(Integer i = 1; i <= 30; i++){
            //testLI
            LiveItem liveItem = new LiveItem(getActivity());

            liveItem.setId(View.generateViewId());
            idList.add(liveItem);

            liveItem.setChString("ch"+i);//"ch"+i
            liveItem.setValue(i+30);

            //add child
            layout.addView(liveItem);
        }

        FloatingActionButton floatingActionButton = view.findViewById(R.id.floating_test);
        floatingActionButton.setOnClickListener(v -> {
            for(Integer i = 0 ; i < idList.size(); i++){
                LiveItem temp = (LiveItem) idList.get(i);
                temp.changeView(getActivity());
                temp.setChString("ch"+(i+1));//"ch"+i
                temp.setValue(i+31);
            }
        });




//        for(Integer i = 10; i < 20; i++){
//            TextView tv = new TextView(getActivity());
//            tv.setText(i.toString());
//            tv.setTextColor(getResources().getColor(R.color.white));
//            //tv.setLayoutParams(layoutParams);
//            layout.addView(tv); // ?????? linearLayout??? textView ??????
//        }


    }
}
