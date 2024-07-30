package com.example.dinelink.retrofit;

import com.example.dinelink.model.FoodItem;
import com.example.dinelink.model.OrderItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MenuApi {

    @GET("/menu/")
    Call<List<FoodItem>> getMenu(@Query("hotelId")int hotelId);

    @GET("/menu/getItem/")
    Call<FoodItem> getOrderItemByItemId(@Query("itemId")int itemId);
}
