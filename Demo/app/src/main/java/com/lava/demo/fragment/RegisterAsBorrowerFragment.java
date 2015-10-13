package com.lava.demo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.Utils;
import com.lava.demo.activity.BorrowerActivity;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

public class RegisterAsBorrowerFragment extends Fragment {
    public RegisterAsBorrowerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register_as_borrower, container, false);
        findWidget(view);
        return view;
    }

    private void findWidget(View view) {
        LinearLayout ll_register = (LinearLayout) view.findViewById(R.id.ll_register);

        final View main_view = view;
        final Context context = main_view.getContext();
        final EditText etName = (EditText) main_view.findViewById(R.id.etName);
        final EditText etAge = (EditText) main_view.findViewById(R.id.etAge);
        final RadioGroup radioGender = (RadioGroup) main_view.findViewById(R.id.radioGender);
        final EditText etAccount = (EditText) main_view.findViewById(R.id.etAccount);
        final EditText etPhone = (EditText) main_view.findViewById(R.id.etPhone);
        final EditText etEmail = (EditText) main_view.findViewById(R.id.etEmail);
        final EditText etJob = (EditText) main_view.findViewById(R.id.etJob);
        final RadioGroup radioEducation = (RadioGroup) main_view.findViewById(R.id.radioEducation);
        final CheckBox cbSales = (CheckBox) view.findViewById(R.id.cbSales);
        final CheckBox cbRent = (CheckBox) view.findViewById(R.id.cbRent);
        final CheckBox cbInvestment = (CheckBox) view.findViewById(R.id.cbInvestment);

        ll_register.setOnClickListener(new View.OnClickListener() {
            // TODO model validation plugin
            @Override

            public void onClick(View viewChild) {
                SharedPreferences sp = getActivity().getSharedPreferences(Config.BORROWER_REGISTER_STATUS, getActivity().MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                boolean isValidated = true;
                String errorMessage = "";

                editor.putBoolean(Config.IS_REGISTERED, true);
                editor.putString(Config.NAME, etName.getText().toString());

                int ageInteger = Utils.formatInteger(etAge.getText().toString());
                if (ageInteger > 0) {
                    editor.putInt(Config.AGE, ageInteger);
                } else {
                    isValidated = false;
                    errorMessage += "Wrong Age!";
                }

                int radioGenderInstance = radioGender.getCheckedRadioButtonId();
                if (radioGenderInstance != -1) {
                    editor.putString(Config.GENDER,
                            ((RadioButton) main_view.findViewById(radioGenderInstance)).getText().toString());
                } else {
                    isValidated = false;
                    errorMessage += "Wrong Gender!";
                }

                editor.putString(Config.ACCOUNT, etAccount.getText().toString());

                editor.putString(Config.PHONE, etPhone.getText().toString());
                editor.putString(Config.EMAIL, etEmail.getText().toString());
                editor.putString(Config.JOB, etJob.getText().toString());

                int radioEducationInstance = radioEducation.getCheckedRadioButtonId();
                if (radioEducationInstance != -1) {
                    editor.putString(Config.EDUCATION, ((RadioButton) main_view.findViewById(radioEducationInstance)).getText().toString());
                } else {
                    isValidated = false;
                    errorMessage += "Wrong Education!";
                }

                ArrayList<String> revenueList = new ArrayList<>();
                if (cbSales.isChecked()) {
                    revenueList.add(cbSales.getText().toString());
                }
                if (cbRent.isChecked()) {
                    revenueList.add(cbRent.getText().toString());
                }
                if (cbInvestment.isChecked()) {
                    revenueList.add(cbInvestment.getText().toString());
                }
                String revenueValue = Utils.implode(revenueList, ", ");
                editor.putString(Config.REVENUE, revenueValue);

                if (isValidated) {
                    editor.putFloat(Config.CREDIT_SCORE, (float) 7.3);
                    editor.apply();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), BorrowerActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
