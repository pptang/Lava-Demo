package com.lava.demo.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.lava.demo.Config;
import com.lava.demo.R;

import java.util.Calendar;


public class BorrowerFormFragment extends DialogFragment implements View.OnTouchListener,
        DatePickerDialog.OnDateSetListener {

    private EditText etFrom;
    private EditText etTo;
    public final int FROM_REQUEST_CODE = 0;
    public final int TO_REQUEST_CODE = 1;
    public static final String DATEPICKER_TAG = "datepicker";

    public BorrowerFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrower_form, container, false);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        DatePickerDialog dpd = (DatePickerDialog) getChildFragmentManager().findFragmentByTag(DATEPICKER_TAG);

        if (dpd != null) {
            dpd.setOnDateSetListener(this);
        }

        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {
        RelativeLayout rlContainer = (RelativeLayout) v.findViewById(R.id.rl_container);
        rlContainer.setOnTouchListener(this);

        TextView tvLenderName = (TextView) v.findViewById(R.id.tvLenderName);
        tvLenderName.setText(getActivity()
                .getSharedPreferences(Config.BORROWER_REGISTER_STATUS, Context.MODE_PRIVATE)
                .getString(Config.NAME, "User"));


        LinearLayout llConfirm = (LinearLayout) v.findViewById(R.id.llConfirm);
        llConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Successfully Sent !");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dismiss();
                        Fragment fragment = new LenderDealFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container, fragment).commit();

                    }
                });
                builder.show();
            }

        });
        final Calendar calendar = Calendar.getInstance();
        final DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
        etFrom = (EditText) v.findViewById(R.id.etFrom);
        etFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.setVibrate(false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.setCloseOnSingleTapDay(true);
                datePickerDialog.show(getChildFragmentManager(), DATEPICKER_TAG);
                datePickerDialog.setTargetFragment(getParentFragment(), FROM_REQUEST_CODE);
            }
        });
        etTo = (EditText) v.findViewById(R.id.etTo);
        etTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.setVibrate(false);
                datePickerDialog.setYearRange(1985, 2028);
                datePickerDialog.setCloseOnSingleTapDay(true);
                datePickerDialog.show(getChildFragmentManager(), DATEPICKER_TAG);
                datePickerDialog.setTargetFragment(getParentFragment(), TO_REQUEST_CODE);

            }
        });


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromInputMethod(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return false;
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {

        switch (datePickerDialog.getTargetRequestCode()) {
            case FROM_REQUEST_CODE:
                etFrom.setText(month + "/" + day + "/" + year);
                break;
            case TO_REQUEST_CODE:
                etTo.setText(month + "/" + day + "/" + year);
                break;
        }

    }
}
