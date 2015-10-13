package com.lava.demo.fragment;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.lava.demo.Config;
import com.lava.demo.R;
import com.lava.demo.db.LendTable;
import com.lava.demo.logger.Dump;
import com.lava.demo.model.LendItem;

import de.greenrobot.event.EventBus;


/**
 * A simple {@link Fragment} subclass.
 */
public class LendMoneyFragment extends Fragment implements View.OnTouchListener,
        AdapterView.OnItemSelectedListener{

    LinearLayout llSend;
    EditText etName;
    EditText etAmount;
    Context context;
    Spinner spinnerRate;
    String selectedRates = "";
    public LendMoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lend_money, container, false);
        getActivity().setTitle("Lend Money");
        context = getActivity();
        findWidgets(view);

        return view;
    }

    private void findWidgets(View view) {
        RelativeLayout rlLend = (RelativeLayout) view.findViewById(R.id.rl_lend);
        rlLend.setOnTouchListener(this);
        etAmount = (EditText) view.findViewById(R.id.etAmount);
        etName = (EditText) view.findViewById(R.id.etName);
        spinnerRate = (Spinner) view.findViewById(R.id.spinnerRate);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.rates_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRate.setAdapter(adapter);
        spinnerRate.setOnItemSelectedListener(this);
        llSend = (LinearLayout) view.findViewById(R.id.ll_send);
        llSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIntoLendTable(etName.getText().toString(), etAmount.getText().toString(),
                        selectedRates);


            }
        });

        setLenderName();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedRates = parent.getSelectedItem().toString();
        Dump.e(selectedRates);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void insertIntoLendTable(final String name, final String amount, final String rate) {

        new AsyncTask<Void, Void, LendItem>() {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(context);
                dialog.setMessage("Loading...");
                dialog.show();
            }

            @Override
            protected LendItem doInBackground(Void... params) {

                LendTable lendTable = new LendTable(context);
                LendItem item = new LendItem(name, amount, rate);
                lendTable.insert(item);

                return item;
            }

            @Override
            protected void onPostExecute(LendItem item) {
                super.onPostExecute(item);

                EventBus.getDefault().post(item);

                dialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Success!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container, new LendMoneyListFragment())
                                .commit();
                    }

                });
                builder.show();

            }
        }.execute();
    }

    private void setLenderName() {
        SharedPreferences sharePref = getActivity().getSharedPreferences(Config.LENDER_REGISTER_STATUS, Context.MODE_PRIVATE);
        String lenderName = sharePref.getString(Config.NAME, "Boss");
        etName.setText(lenderName);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        return false;
    }

}
