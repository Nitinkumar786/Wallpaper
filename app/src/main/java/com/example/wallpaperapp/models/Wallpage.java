package com.example.wallpaperapp.models;



import com.example.wallpaperapp.ImageDimension;


public class Wallpage {

    private ImageDimension src;

    public Wallpage(ImageDimension src) {
        this.src = src;
    }

    public ImageDimension getSrc() {
        return src;
    }

    public void setSrc(ImageDimension src) {
        this.src = src;
    }



}
