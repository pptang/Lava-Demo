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


/**
 * A simple {@link Fragment} subclass.
 */
public class BorrowerProfileFragment extends Fragment {
    private Activity activity;
    private ArrayList<ProfileItem> profileItems = new ArrayList<ProfileItem>();
    private RecyclerView borrowerProfileRecyclerView;
    private RecyclerView.Adapter profileAdapter;

    public BorrowerProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_profile, container, false);

        activity = getActivity();
        activity.setTitle("Profile");

        SharedPreferences sp = activity.getSharedPreferences(Config.BORROWER_REGISTER_STATUS, activity.MODE_PRIVATE);
        String name = sp.getString("name", "");
        int age = sp.getInt("age", 0);
        String gender = sp.getString("gender", "");
        String account = sp.getString("account", "");
        String phone = sp.getString("phone", "");
        String email = sp.getString("email", "");
        String job = sp.getString("job", "");
        String education = sp.getString("education", "");
        String revenue = sp.getString("revenue", "");

        profileItems.add(new ProfileItem("Name", name, R.drawable.icon_name));
        if (age > 0) {
            profileItems.add(new ProfileItem("Age", String.valueOf(age), R.drawable.icon_age));
        }
        profileItems.add(new ProfileItem("Gender", gender, R.drawable.icon_gender));
        profileItems.add(new ProfileItem("Account", account, R.drawable.icon_account));
        profileItems.add(new ProfileItem("Phone", phone, R.drawable.icon_phone));
        profileItems.add(new ProfileItem("Email", email, R.drawable.icon_email));
        profileItems.add(new ProfileItem("Job", job, R.drawable.icon_job));
        profileItems.add(new ProfileItem("Education", education, R.drawable.icon_education));
        profileItems.add(new ProfileItem("Source of Revenue", revenue, R.drawable.icon_revenue));

        borrowerProfileRecyclerView = (RecyclerView) view.findViewById(R.id.borrower_profile_recycler_view);
        borrowerProfileRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

        profileAdapter = new ProfileAdapter(profileItems);
        borrowerProfileRecyclerView.setAdapter(profileAdapter);

        borrowerProfileRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}
