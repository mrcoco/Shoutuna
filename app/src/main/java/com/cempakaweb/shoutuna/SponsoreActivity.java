package com.cempakaweb.shoutuna;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cempakaweb.shoutuna.adapter.SponsorAdapter;
import com.cempakaweb.shoutuna.api.Sponsor;
import com.cempakaweb.shoutuna.model.SponsorModels;
import com.cempakaweb.shoutuna.model.SponsorResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SponsoreActivity extends AppCompatActivity {
    public static final String URL = "http://dev.cempakaweb.com/shoutuna/";
    List<SponsorModels> sponsorModelsList =  new ArrayList<>();
    SponsorAdapter sponsorAdapter;
    RecyclerView rvSponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsore);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sponsor sponsor = retrofit.create(Sponsor.class);

        sponsorAdapter = new SponsorAdapter(getApplicationContext(),sponsorModelsList);
        rvSponsor = (RecyclerView) findViewById(R.id.rvSponsor);
        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(SponsoreActivity.this);
        rvSponsor.setLayoutManager(mLayoutmanager);

        Call<SponsorResponse> call = sponsor.getResult();
        call.enqueue(new Callback<SponsorResponse>() {
            @Override
            public void onResponse(Call<SponsorResponse> call, Response<SponsorResponse> response) {
                final List<SponsorModels> sponsorModelsList = response.body().getResult();
                rvSponsor.setAdapter(new SponsorAdapter(getApplicationContext(),sponsorModelsList));
                sponsorAdapter.notifyDataSetChanged();
                //Log.w("response", new Gson().toJson(response.body().getResult()));


            }

            @Override
            public void onFailure(Call<SponsorResponse> call, Throwable t) {
                Log.d("response-fail", new Gson().toJson(t));
            }
        });
    }

}
