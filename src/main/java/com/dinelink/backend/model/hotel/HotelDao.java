package com.dinelink.backend.model.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
