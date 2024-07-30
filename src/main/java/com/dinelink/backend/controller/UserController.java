package com.dinelink.backend.controller;

import com.dinelink.backend.model.Hotel;
import com.dinelink.backend.service.HotelDao;
import com.dinelink.backend.model.User;
import com.dinelink.backend.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hotel/setip")
    public void setHotelIp(@RequestParam("hotel_ip")String hotel_ip,
                           @RequestParam("hotel_id")int hotel_id)
    {
        hotelDao.setIp(hotel_ip,hotel_id);
    }
}
