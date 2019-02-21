package com.cempakaweb.shoutuna.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SponsorModels {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("description")
    @Expose
    private String description;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFoto() {
        return foto;
    }

    public String getDescription() {
        return description;
    }
}
