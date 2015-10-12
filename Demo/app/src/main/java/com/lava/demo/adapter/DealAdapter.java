package com.lava.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.lava.demo.R;
import com.lava.demo.model.DealInfo;

import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealAdapter.ViewHolder> {

    private List<DealInfo> dealInfos;
    private Context context;

    public DealAdapter(Context context, List<DealInfo> dealInfos) {
        this.dealInfos = dealInfos;
        this.context = context;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvPeriod;
        public TextView tvPurpose;
        public TextView tvMethod;
        public TextView tvRevenue;
        public TextView tvGurantee;
        public Button btnAccept;

        public ViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvPeriod = (TextView) v.findViewById(R.id.tvPeriod);
            tvPurpose = (TextView) v.findViewById(R.id.tvPurpose);
            tvMethod = (TextView) v.findViewById(R.id.tvMethod);
            tvRevenue = (TextView) v.findViewById(R.id.tvRevenue);
            tvGurantee = (TextView) v.findViewById(R.id.tvGurantee);
            btnAccept = (Button) v.findViewById(R.id.btnAccept);
        }
    }

    @Override
    public DealAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lender_deal_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DealAdapter.ViewHolder holder, int position) {
        DealInfo dealInfo = dealInfos.get(position);
        holder.tvName.setText("Name： " + dealInfo.getBorrowerName());
        holder.tvPeriod.setText("Period： " + dealInfo.getPeriod());
        holder.tvPurpose.setText("Purpose： " + dealInfo.getPurpose());
        holder.tvMethod.setText("Methods of Repayment： " + dealInfo.getMethod());
        holder.tvRevenue.setText("Revenue： " + dealInfo.getRevenue());
        holder.tvGurantee.setText("Gurantee： " + dealInfo.getGurantee());
//        holder.btnAccept.setOnClickListener(view -> {
//            Alert.show(context, "Deal!");
//        });
    }

    @Override
    public int getItemCount() {
        return dealInfos.size();
    }

}