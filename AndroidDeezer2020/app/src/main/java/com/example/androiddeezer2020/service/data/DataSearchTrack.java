package com.example.androiddeezer2020.service.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSearchTrack {

    @SerializedName("data")
    @Expose
    private List<Track> data = null;

    public List<Track> getData() {
        return data;
    }

    public void setData(List<Track> data) {
        this.data = data;
    }

}
