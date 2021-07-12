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

public class Fragment1st extends Fragment {

    Integer count = 0;



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

        GridLayout layout = view.findViewById(R.id.layout1st);
        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.LayoutParams test = layout.getLayoutParams();

        for(Integer i = 10; i < 20; i++){
            //toCheckParams
            //ConstraintLayout toCheckParams = view.findViewById(R.id.test_size);
            ViewGroup.LayoutParams checkParams = new ViewGroup.LayoutParams(
                    (int)getResources().getDimension(R.dimen.liveItemWidth),
                    (int)getResources().getDimension(R.dimen.liveItemHeight));
            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(checkParams);
            margin.setMargins(
                    (int)getResources().getDimension(R.dimen.liveItemMargin),
                    (int)getResources().getDimension(R.dimen.liveItemMargin),
                    (int)getResources().getDimension(R.dimen.liveItemMargin),
                    (int)getResources().getDimension(R.dimen.liveItemMargin)
                    );
            //ViewGroup.LayoutParams checkParams = toCheckParams.getLayoutParams();


            //layout item
            ConstraintLayout testCL = new ConstraintLayout(getActivity());
            testCL.setId(View.generateViewId());
            testCL.setBackground(getResources().getDrawable(R.drawable.live_view_item));
            testCL.setLayoutParams(margin);

            //testLI
            LiveItem liveItem = new LiveItem(getActivity());

            liveItem.setChString("test1"+i);
            liveItem.setValue(i+30);


            //ch number
            TextView chNumber = new TextView(getActivity());
            chNumber.setText(i.toString());
            chNumber.setTextColor(getResources().getColor(R.color.white));
            chNumber.setId(View.generateViewId());
            ConstraintSet setChNumber = new ConstraintSet();
            setChNumber.clone(testCL);
            setChNumber.connect(chNumber.getId(), ConstraintSet.TOP, testCL.getId(), ConstraintSet.TOP,
                    (int)getResources().getDimension(R.dimen.margin20dp));
            setChNumber.connect(chNumber.getId(), ConstraintSet.LEFT, testCL.getId(), ConstraintSet.LEFT,
                    (int)getResources().getDimension(R.dimen.margin40dp));



            //add child
            layout.addView(liveItem);
            //testCL.addView(chNumber, 0);
            //ConstraintLayout testCL_temp = view.findViewById(testCL.getId());


            //constraint
            //setChNumber.applyTo(testCL);
        }




//        for(Integer i = 10; i < 20; i++){
//            TextView tv = new TextView(getActivity());
//            tv.setText(i.toString());
//            tv.setTextColor(getResources().getColor(R.color.white));
//            //tv.setLayoutParams(layoutParams);
//            layout.addView(tv); // 기존 linearLayout에 textView 추가
//        }


    }
}
