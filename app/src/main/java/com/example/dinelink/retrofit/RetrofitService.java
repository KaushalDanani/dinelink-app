package com.example.dinelink.retrofit;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import java.lang.ref.Cleaner;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService{

    Retrofit retrofit;

    public RetrofitService() {
        initializeRetrofit();
    }

    void initializeRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.102:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit(){
        return retrofit;
    }

}
