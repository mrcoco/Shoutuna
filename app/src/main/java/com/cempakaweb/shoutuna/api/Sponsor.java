package com.cempakaweb.shoutuna.api;

import com.cempakaweb.shoutuna.model.SponsorResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Sponsor {
    @GET("sponsor")
    Call<SponsorResponse>getResult();
}
