package com.dinelink.backend.controller;

import com.dinelink.backend.model.FoodItem;
import com.dinelink.backend.model.OrderItem;
import com.dinelink.backend.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    FoodItemService ms;

    @GetMapping(value = "/")
    public List<FoodItem> getMenu(@RequestParam("hotelId")int hotelId)
    {
        List<FoodItem> menu = ms.getMenu(hotelId);
        return menu;
    }

    @GetMapping(value = "/getItem/")
    FoodItem getItemById(@RequestParam("itemId")int itemId){
        return ms.getItemById(itemId);
    }

}
