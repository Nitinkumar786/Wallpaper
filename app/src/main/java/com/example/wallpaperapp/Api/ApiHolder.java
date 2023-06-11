package com.example.wallpaperapp.Api;

import com.example.wallpaperapp.models.Wallpaper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiHolder {
    @GET("curated")
    Call<Wallpaper> getWallpaper(
            @Header("Authorization") String credentials,
            @Query("page") int pageCount,
            @Query("per_page")int parpage
    );

}
