package com.cempakaweb.shoutuna.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cempakaweb.shoutuna.R;
import com.cempakaweb.shoutuna.model.SponsorModels;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SponsorAdapter extends RecyclerView.Adapter<SponsorAdapter.SponsorHolder>{
    List<SponsorModels> sponsorModelsList;
    Context mContext;

    public SponsorAdapter(Context context, List<SponsorModels> sponsorList){
        this.mContext = context;
        sponsorModelsList = sponsorList;
    }

    @Override
    public SponsorHolder onCreateViewHolder(ViewGroup parrent, int viewType) {
        View itemView = LayoutInflater.from(parrent.getContext()).inflate(R.layout.list_sponsor,parrent,false);
        return new SponsorHolder(itemView);

    }

    @Override
    public void onBindViewHolder(SponsorHolder holder, int position) {
        final SponsorModels sponsorModels = sponsorModelsList.get(position);
        String _HOST_URL = "http://dev.cempakaweb.com/storage/";
        Uri logo = Uri.parse(_HOST_URL+sponsorModels.getFoto());
        Picasso.get().load(logo)
                .resize(150, 150)
                .centerCrop()
                .into(holder.sponsorImageDrawable);
        holder.sponsorNameDrawable.setText(sponsorModels.getName());

    }

    @Override
    public int getItemCount() {
        return sponsorModelsList.size();
    }

    public class SponsorHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sponsor_image)
        ImageView sponsorImageDrawable;
        @BindView(R.id.sponsor_name)
        TextView sponsorNameDrawable;

        public SponsorHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
