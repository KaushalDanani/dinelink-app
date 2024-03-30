package com.example.dinelink.retrofit;

import com.example.dinelink.model.Hotel;
import com.example.dinelink.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HotelApi {

    @GET("/hotel/gethotel")
    Call<List<Hotel>> getAllHotel();

    @POST("/hotel/addhotel")
    Call<Hotel> save(@Body Hotel hotel);

}
