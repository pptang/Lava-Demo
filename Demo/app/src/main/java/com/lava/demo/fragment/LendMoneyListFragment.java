package com.lava.demo.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lava.demo.R;
import com.lava.demo.adapter.LendMoneyListAdapter;
import com.lava.demo.db.LendTable;
import com.lava.demo.model.LendItem;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

public class LendMoneyListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;
    private LinearLayout llEmpty;
    public LendMoneyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lend_money_list, container, false);
        EventBus.getDefault().register(this);
        context = getActivity();
        getActivity().setTitle("Loan Broker");
        findWidgets(view);

        getLendItems();

        return view;
    }

    private void findWidgets(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        llEmpty = (LinearLayout) view.findViewById(R.id.ll_empty);
    }

    private void getLendItems() {
        new AsyncTask<Void, Void, Void>() {

            List<LendItem> lendItems = new ArrayList<LendItem>();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {

                LendTable lendTable = new LendTable(context);
                lendItems = lendTable.getAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (lendItems.size() == 0) {
                    llEmpty.setVisibility(View.VISIBLE);
                } else {
                    llEmpty.setVisibility(View.GONE);
                }
                adapter = new LendMoneyListAdapter(context, lendItems, getChildFragmentManager());
                recyclerView.setAdapter(adapter);
            }
        }.execute();
    }

    public void onEvent(LendItem lendItem) {

        ((LendMoneyListAdapter) adapter).addItem(lendItem);
        llEmpty.setVisibility(View.GONE);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

}
