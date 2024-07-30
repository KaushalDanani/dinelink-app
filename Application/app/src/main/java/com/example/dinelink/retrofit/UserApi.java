package com.example.dinelink.retrofit;

import com.example.dinelink.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {

    @GET("/user/getuser")
    Call<List<User>> getAllUser();

    @POST("/user/adduser")
    Call<User> save(@Body User user);

}
