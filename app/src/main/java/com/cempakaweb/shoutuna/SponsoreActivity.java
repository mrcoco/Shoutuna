package com.cempakaweb.shoutuna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.cempakaweb.shoutuna.api.Sponsor;
import com.cempakaweb.shoutuna.model.SponsorModels;
import com.cempakaweb.shoutuna.model.SponsorResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SponsoreActivity extends AppCompatActivity {
    public static final String URL = "http://dev.cempakaweb.com/shoutuna/";
    List<SponsorModels> sponsorModelsList =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsore);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Sponsor sponsor = retrofit.create(Sponsor.class);
        Call<SponsorResponse> call = sponsor.getResult();
        call.enqueue(new Callback<SponsorResponse>() {
            @Override
            public void onResponse(Call<SponsorResponse> call, Response<SponsorResponse> response) {
                final List<SponsorModels> sponsorModelsList = response.body().getResult();
                
                //Log.w("response", new Gson().toJson(response.body().getResult()));


            }

            @Override
            public void onFailure(Call<SponsorResponse> call, Throwable t) {
                Log.d("response-fail", new Gson().toJson(t));
            }
        });

    }
}
