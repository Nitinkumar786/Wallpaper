package com.example.wallpaperapp.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static  String baseUrl="https://api.pexels.com/v1/";

    private static RetrofitClient retrofitClient;
    private final Retrofit retrofit;

    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    public RetrofitClient()
    {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null)
        {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

public ApiHolder getApiHplder(){
        return retrofit.create(ApiHolder.class)   ;
}


}
 