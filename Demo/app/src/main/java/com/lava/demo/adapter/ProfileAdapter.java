package com.lava.demo.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lava.demo.R;
import com.lava.demo.model.ProfileItem;

import java.util.ArrayList;


public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private ArrayList<ProfileItem> profileItems;

    public ProfileAdapter(ArrayList<ProfileItem> profileItems) {
        this.profileItems = profileItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        View profileItemLayoutView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_item_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(profileItemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.textViewTitle.setText(profileItems.get(position).getTitle());
        viewHolder.textViewValue.setText(profileItems.get(position).getValue());
        viewHolder.imageViewIcon.setImageResource(profileItems.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return profileItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public TextView textViewValue;
        public ImageView imageViewIcon;

        public ViewHolder(View profileItemLayoutView) {
            super(profileItemLayoutView);

            textViewTitle = (TextView) profileItemLayoutView.findViewById(R.id.title);
            textViewValue = (TextView) profileItemLayoutView.findViewById(R.id.value);
            imageViewIcon = (ImageView) profileItemLayoutView.findViewById(R.id.icon);
        }
    }
}
