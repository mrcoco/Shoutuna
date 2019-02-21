package com.cempakaweb.shoutuna.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SponsorResponse {
    @SerializedName("results")
    private List<SponsorModels> result;

    public List<SponsorModels> getResult() {
        return result;
    }
}
