package com.dinelink.backend.model.hotel;

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

}
