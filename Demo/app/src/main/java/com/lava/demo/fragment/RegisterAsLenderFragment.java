package com.lava.demo.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.Utils;
import com.lava.demo.activity.LenderActivity;
import com.lava.demo.logger.Dump;

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

    private void findWidgets(final View view) {
        LinearLayout llRegister = (LinearLayout) view.findViewById(R.id.ll_register);

        final EditText etName = (EditText) view.findViewById(R.id.etName);
        final EditText etAge = (EditText) view.findViewById(R.id.etAge);
        final RadioGroup radioGender = (RadioGroup) view.findViewById(R.id.radioGender);
        final EditText etAccount = (EditText) view.findViewById(R.id.etAccount);
        final EditText etPhone = (EditText) view.findViewById(R.id.etPhone);
        final EditText etEmail = (EditText) view.findViewById(R.id.etEmail);
        final EditText etJob = (EditText) view.findViewById(R.id.etJob);
        final RadioGroup radioEducation = (RadioGroup) view.findViewById(R.id.radioEducation);

        llRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharePref =
                        getActivity().getSharedPreferences(Config.LENDER_REGISTER_STATUS, getActivity().MODE_PRIVATE);
                SharedPreferences.Editor editor = sharePref.edit();
                editor.putBoolean(Config.IS_REGISTERED, true);
                editor.putString(Config.NAME, etName.getText().toString());

                StringBuilder errorBuilder = new StringBuilder();
                boolean isValidated = false;
                do {

                    int ageInteger = Utils.formatInteger(etAge.getText().toString());
                    if (ageInteger > 0) {
                        editor.putInt(Config.AGE, ageInteger);
                    } else {
                        errorBuilder.append("Wrong Age!");
                        break;
                    }

                    int radioGenderInstance = radioGender.getCheckedRadioButtonId();
                    if (radioGenderInstance != -1) {
                        editor.putString(Config.GENDER,
                                ((RadioButton) view.findViewById(radioGenderInstance)).getText().toString());
                    } else {
                        errorBuilder.append("Wrong Gender!");
                        break;
                    }

                    editor.putString(Config.ACCOUNT, etAccount.getText().toString());

                    editor.putString(Config.PHONE, etPhone.getText().toString());
                    editor.putString(Config.EMAIL, etEmail.getText().toString());
                    editor.putString(Config.JOB, etJob.getText().toString());

                    int radioEducationInstance = radioEducation.getCheckedRadioButtonId();
                    if (radioEducationInstance != -1) {
                        editor.putString(Config.EDUCATION, ((RadioButton) view.findViewById(radioEducationInstance))
                                .getText().toString());
                    } else {
                        errorBuilder.append("Wrong Education!");
                        break;
                    }

                    isValidated = true;

                } while (false);

                if (isValidated) {
                    editor.putFloat(Config.RISK_SCORE, (float) 4.9);
                    editor.apply();
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), LenderActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getActivity(), errorBuilder.toString(), Toast.LENGTH_LONG).show();
                }


            }
        });

    }


}
