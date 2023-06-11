package com.example.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wallpaperapp.Api.RetrofitClient;
import com.example.wallpaperapp.models.Wallpage;
import com.example.wallpaperapp.models.Wallpaper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView imageRecycleView;
    private final String API_KEY="qmx2NQddwOmnm45D9q9H6v38hORVPV8MLuG2ycdrDEwVrazcmumOEWOo";
    private int page_count=1;
    private static int par_page=80;
    private List<Wallpage>wallpageList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageRecycleView = findViewById(R.id.recycleview);
        imageRecycleView.setHasFixedSize(true);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        imageRecycleView.setLayoutManager(gridLayoutManager);
        fetchData(page_count);

    }

    private void fetchData(int page_count) {
        Call<Wallpaper> call = RetrofitClient
                .getInstance()
                .getApiHplder()
                .getWallpaper(API_KEY,page_count,par_page);

        call.enqueue(new Callback<Wallpaper>() {
            @Override
            public void onResponse(Call<Wallpaper> call, Response<Wallpaper> response) {
                Wallpaper wallpaper = response.body();
                if (response.isSuccessful() && null!=wallpaper){
                    wallpageList.addAll(wallpaper.getPhotoList());
                    WallpaperAdapter wallpaperAdapter = new WallpaperAdapter(getApplicationContext(),wallpageList);
                    imageRecycleView.setAdapter(wallpaperAdapter);
                    wallpaperAdapter.notifyDataSetChanged();
                }
                else
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Wallpaper> call, Throwable t) {

                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}