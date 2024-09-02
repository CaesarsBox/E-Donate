package com.example.edonator.ui.Donor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.edonator.R;

import java.util.ArrayList;

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.DonorViewHolder> {

    private ArrayList<DonorModel> mDonorList;

    public DonorAdapter(ArrayList<DonorModel> donorList) {
        mDonorList = donorList;
    }

    @NonNull
    @Override
    public DonorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.try_this, parent, false);
        return new DonorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonorViewHolder holder, int position) {
        DonorModel currentItem = mDonorList.get(position);

        holder.mDonorName.setText(currentItem.getName());
        holder.mDonorContact.setText(currentItem.getContact());
        holder.mDonorAddress.setText(currentItem.getAddress());
    }

    @Override
    public int getItemCount() {
        return mDonorList.size();
    }

    public static class DonorViewHolder extends RecyclerView.ViewHolder {

        public TextView mDonorName;
        public TextView mDonorContact;
        public TextView mDonorAddress;

        public DonorViewHolder(View itemView) {
            super(itemView);
            mDonorName = itemView.findViewById(R.id.donorName);
            mDonorContact = itemView.findViewById(R.id.donorContact);
            mDonorAddress = itemView.findViewById(R.id.donorAddress);
        }
    }
}
