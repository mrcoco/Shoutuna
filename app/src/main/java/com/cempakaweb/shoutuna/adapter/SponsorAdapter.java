package com.cempakaweb.shoutuna.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cempakaweb.shoutuna.R;

import butterknife.ButterKnife;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.SponsorHolder>{

    @Override
    public SponsorHolder onCreateViewHolder(ViewGroup parrent, int viewType) {
        View itemView = LayoutInflater.from(parrent.getContext()).inflate(R.layout.list_sponsor,parrent,false);
        return new SponsorHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull SponsorHolder sponsorHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class SponsorHolder extends RecyclerView.ViewHolder {


        public SponsorHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
