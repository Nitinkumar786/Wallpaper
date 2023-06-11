package com.example.wallpaperapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Wallpaper {
    @SerializedName("photos")
    private List<Wallpage> photoList;

    public Wallpaper(List<Wallpage> photoList) {
        this.photoList = photoList;
    }

    public List<Wallpage> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Wallpage> photoList) {
        this.photoList = photoList;
    }
}

