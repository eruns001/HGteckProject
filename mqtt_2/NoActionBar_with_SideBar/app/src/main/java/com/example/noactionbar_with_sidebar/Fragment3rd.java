package com.example.noactionbar_with_sidebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

        for(Integer i = 1; i <= 30; i++){
            //testLI
            CorrectionItem correctionItem = new CorrectionItem(getActivity());

            correctionItem.setChString("ch"+i);
            correctionItem.setValue(i+30);

            //add child
            layout.addView(correctionItem);
        }
        //실행내용
    }
}
