package com.lava.demo.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lava.demo.R;
import com.lava.demo.activity.BorrowerActivity;
import com.lava.demo.activity.LenderActivity;

public class WelcomeFragment extends Fragment {


    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {

        TextView tvLend = (TextView) v.findViewById(R.id.tvLendTitle);
        TextView tvBorrow = (TextView) v.findViewById(R.id.tvBorrowTitle);

        tvLend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistered("RegisterAsLender")) {
                    Intent intent = new Intent(getActivity(), LenderActivity.class);
                    startActivity(intent);
                } else {
                    Fragment fragment = new RegisterAsLenderFragment();

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }

            }
        });

        tvBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegistered("RegisterAsBorrower")) {
                    Intent intent = new Intent(getActivity(), BorrowerActivity.class);
                    startActivity(intent);
                } else {
                    Fragment fragment = new RegisterAsBorrowerFragment();

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.welcome_container, fragment)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

    }

    private boolean isRegistered(String registerTitle) {
        SharedPreferences sharePref = getActivity().getSharedPreferences(registerTitle, Context.MODE_PRIVATE);
        return sharePref.getBoolean("isRegistered", false);
    }

}
