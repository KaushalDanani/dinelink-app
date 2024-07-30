package com.example.dinelink.retrofit;

import com.example.dinelink.model.OrderItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrderItemApi {

    @GET("/orderItems/")
    Call<List<OrderItem>> getOrderItems(@Query("orderId")int orderId);

    @GET("/orderItems/remove/")
    Call<Void> removeOrderItems(@Query("orderId")int orderId);

    @POST("/orderItems/addOrderItems")
    Call<Void> addOrderItems(@Body OrderItem orderItem);
}
