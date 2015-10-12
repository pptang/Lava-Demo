package com.lava.demo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lava.demo.R;
import com.lava.demo.model.LendItem;

import java.util.List;


public class LendMoneyListAdapter extends RecyclerView.Adapter<LendMoneyListAdapter.ViewHolder> {

    private List<LendItem> lendItems;
    private Context context;
    private FragmentManager fragmentManager;
    public LendMoneyListAdapter(Context context, List<LendItem> lendItems, FragmentManager fm) {
        this.lendItems = lendItems;
        this.context = context;
        this.fragmentManager = fm;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView itemContainer;
        public TextView tvName;
        public TextView tvAmount;
        public TextView tvRate;
        public Button btnBorrow;
        public ViewHolder(View v) {
            super(v);
            itemContainer = (CardView) v.findViewById(R.id.item_container);
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvAmount = (TextView) v.findViewById(R.id.tvAmount);
            tvRate = (TextView) v.findViewById(R.id.tvRate);
            btnBorrow = (Button) v.findViewById(R.id.btnBorrow);
        }
    }

    @Override
    public LendMoneyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lend_money_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LendMoneyListAdapter.ViewHolder holder, int position) {
        LendItem item = lendItems.get(position);
        holder.tvName.setText("Name： " + item.getName());
        holder.tvAmount.setText("Amount： " + item.getAmount() + "NT");
        holder.tvRate.setText("Rate： " + item.getRate() + "%");
//        holder.btnBorrow.setOnClickListener(v -> {
//            DialogFragment fragment = new BorrowerFormFragment();
//            fragment.show(fragmentManager, "fragment_borrower_form");
//            holder.btnBorrow.setEnabled(false);
//            holder.btnBorrow.setText("Processing");
//
//        });
//
//        holder.itemContainer.setOnClickListener(view -> {
//            DialogFragment fragment = new LenderInfoFragment();
//            fragment.show(fragmentManager, "fragment_lender_info");
//
//        });
    }

    @Override
    public int getItemCount() {
        return lendItems.size();
    }

    public void addItem(LendItem item) {

        lendItems.add(0, item);
        notifyDataSetChanged();

    }
}
