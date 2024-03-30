package com.dinelink.backend.controller;

import com.dinelink.backend.model.hotel.Hotel;
import com.dinelink.backend.model.hotel.HotelDao;
import com.dinelink.backend.model.user.User;
import com.dinelink.backend.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private HotelDao hotelDao;

    @GetMapping("/user/getuser")
    public List<User> getUser(){
        return userDao.getAllUser();
    }

    @PostMapping("/user/adduser")
    public User addUser(@RequestBody User user){
        return userDao.save(user);
    }

    @GetMapping("/hotel/gethotel")
    public List<Hotel> getHotel(){
        return hotelDao.getAllHotel();
    }

    @PostMapping("/hotel/addhotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelDao.save(hotel);
    }



}
