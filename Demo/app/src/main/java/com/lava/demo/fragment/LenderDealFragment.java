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

import com.lava.demo.R;
import com.lava.demo.adapter.DealAdapter;
import com.lava.demo.model.DealInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LenderDealFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;

    public LenderDealFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lender_deal, container, false);
        context = getActivity();
        getActivity().setTitle("Deal");
        findWidgets(view);
        getMyDeals();
        // Inflate the layout for this fragment
        return view;
    }

    private void findWidgets(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
    private void getMyDeals() {
        new AsyncTask<Void, Void, Void>() {

            List<DealInfo> dealInfos = new ArrayList<DealInfo>();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {


                DealInfo info1 = new DealInfo("Tommy", "2015/10/02~2016/11/04", "Fund Turnover", "Periodic", "Salary",
                        "Yes");
                DealInfo info2 = new DealInfo("Mark", "2015/11/19~2018/11/19", "Land Purchase", "Bullet Repayment", "Investment",
                        "No");
                DealInfo info3 = new DealInfo("Kevin", "2015/11/19~2015/12/30", "Family Turnover", "Periodic", "Sales",
                        "Yes");
                dealInfos.add(info1);
                dealInfos.add(info2);
                dealInfos.add(info3);


                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter = new DealAdapter(context, dealInfos);
                recyclerView.setAdapter(adapter);
            }
        }.execute();
    }
}
