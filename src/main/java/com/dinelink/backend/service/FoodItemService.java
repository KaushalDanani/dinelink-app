package com.dinelink.backend.service;

import com.dinelink.backend.model.FoodItem;
import com.dinelink.backend.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    FoodItemRepository mr;

    public List<FoodItem> getMenu(@RequestParam("hotelId")int hotelId)
    {
        List<FoodItem> menu = mr.findAllByHotelId(hotelId);

        return menu;

    }

}
