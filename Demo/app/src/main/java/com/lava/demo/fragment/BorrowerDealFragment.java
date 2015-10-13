package com.lava.demo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lava.demo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BorrowerDealFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;

    public BorrowerDealFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Deal");
        return inflater.inflate(R.layout.fragment_borrower_deal, container, false);
    }
}
