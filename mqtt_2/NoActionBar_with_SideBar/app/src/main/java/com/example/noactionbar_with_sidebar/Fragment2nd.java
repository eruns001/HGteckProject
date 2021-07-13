package com.example.noactionbar_with_sidebar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.security.auth.login.LoginException;

public class Fragment2nd extends Fragment {

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

        GridLayout layout = view.findViewById(R.id.layout_log);

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
