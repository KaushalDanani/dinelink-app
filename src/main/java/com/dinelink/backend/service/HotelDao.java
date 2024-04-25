package com.dinelink.backend.service;

import com.dinelink.backend.model.Hotel;
import com.dinelink.backend.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelDao {

    @Autowired
    private HotelRepository repository;

    public Hotel save(Hotel hotel){
        repository.save(hotel);
        return hotel;
    }

    public List<Hotel> getAllHotel(){
        List<Hotel> hotel = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(hotel::add);
        return hotel;
    }

    public void setIp(String hotel_ip,
                      int hotel_id) {
        repository.setIp(hotel_ip,hotel_id);
    }

}
