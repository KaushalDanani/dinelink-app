package com.example.dinelink.retrofit;

import com.example.dinelink.model.Orders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrderApi {

    @GET("/orders/")
    Call<List<Orders>> getOrders(@Query("hotelId")int hotelId);

    @GET("/orders/remove/")
    Call<Void> removeOrder(@Query("orderId")int orderId);

    @POST("/orders/addorder")
    Call<Integer> addOrder(@Body Orders order);
}
