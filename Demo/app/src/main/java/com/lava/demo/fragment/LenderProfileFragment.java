package com.lava.demo.fragment;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.adapter.ProfileAdapter;
import com.lava.demo.model.ProfileItem;

import java.util.ArrayList;

public class LenderProfileFragment extends Fragment {

    private Activity activity;
    private ArrayList<ProfileItem> profileItems = new ArrayList<ProfileItem>();
    private RecyclerView borrowerProfileRecyclerView;
    private RecyclerView.Adapter profileAdapter;

    public LenderProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        activity = getActivity();
        activity.setTitle("Profile");

        SharedPreferences sp = activity.getSharedPreferences(Config.LENDER_REGISTER_STATUS, activity.MODE_PRIVATE);
        String name = sp.getString(Config.NAME, "");
        String account = sp.getString(Config.ACCOUNT, "");
        int deposit = 100000;
        int age = sp.getInt(Config.AGE, 0);
        String gender = sp.getString(Config.GENDER, "");
        String phone = sp.getString(Config.PHONE, "");
        String email = sp.getString(Config.EMAIL, "");
        String job = sp.getString(Config.JOB, "");
        String education = sp.getString(Config.EDUCATION, "");

        profileItems.add(new ProfileItem("Name", name, R.drawable.icon_name));
        profileItems.add(new ProfileItem("Account", account, R.drawable.icon_account));
        profileItems.add(new ProfileItem("Deposit", String.valueOf(deposit), R.drawable.icon_deposit));
        if (age > 0) {
            profileItems.add(new ProfileItem("Age", String.valueOf(age), R.drawable.icon_age));
        }
        profileItems.add(new ProfileItem("Gender", gender, R.drawable.icon_gender));
        profileItems.add(new ProfileItem("Phone", phone, R.drawable.icon_phone));
        profileItems.add(new ProfileItem("Email", email, R.drawable.icon_email));
        profileItems.add(new ProfileItem("Job", job, R.drawable.icon_job));
        profileItems.add(new ProfileItem("Education", education, R.drawable.icon_education));

        borrowerProfileRecyclerView = (RecyclerView) view.findViewById(R.id.profile_recycler_view);
        borrowerProfileRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

        profileAdapter = new ProfileAdapter(profileItems);
        borrowerProfileRecyclerView.setAdapter(profileAdapter);

        borrowerProfileRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
