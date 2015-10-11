package com.lava.demo;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterAsBorrowerFragment extends Fragment {
    public RegisterAsBorrowerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_as_borrower, container, false);
        findWidget(view);
        return view;
    }

    private void findWidget(View view) {
        LinearLayout ll_register = (LinearLayout) view.findViewById(R.id.ll_register);

        ll_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("RegisterAsBorrower", getActivity().MODE_PRIVATE);
                sp.edit().putBoolean("isRegistered", true).apply();

                Intent intent = new Intent(getActivity(), BorrowerActivity.class);
                startActivity(intent);
            }
        });
    }
}
