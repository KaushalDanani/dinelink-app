package com.example.dinelink.retrofit;

import com.example.dinelink.model.OrderItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrderItemApi {

    @GET("/orderItems/")
    Call<List<OrderItem>> getOrderItems(@Query("orderId")int orderId);
}
