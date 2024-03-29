package com.example.dinelink.retrofit;

import com.example.dinelink.model.FoodItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MenuApi {

    @GET("/menu/")
    Call<List<FoodItem>> getMenu(@Query("hotelId")int hotelId);
}
