package com.example.dinelink.retrofit;

import com.example.dinelink.model.Orders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrderApi {

    @GET("/orders/")
    Call<List<Orders>> getOrders(@Query("hotelId")int hotelId);
}