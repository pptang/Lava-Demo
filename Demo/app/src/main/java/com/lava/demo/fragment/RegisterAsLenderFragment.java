package com.lava.demo.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.activity.LenderActivity;

public class RegisterAsLenderFragment extends Fragment {


    public RegisterAsLenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_as_lender, container, false);
        findWidgets(view);
        return view;
    }

    private void findWidgets(View view) {
        LinearLayout llRegister = (LinearLayout) view.findViewById(R.id.ll_register);
        llRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharePref =
                        getActivity().getSharedPreferences(Config.LENDER_REGISTER_STATUS, getActivity().MODE_PRIVATE);
                sharePref.edit().putBoolean(Config.IS_REGISTERED, true).apply();

                Intent intent = new Intent(getActivity(), LenderActivity.class);
                startActivity(intent);
            }
        });

    }


}