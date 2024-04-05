package com.dinelink.backend.controller;

import com.dinelink.backend.model.Orders;
import com.dinelink.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    OrdersService os;

    @GetMapping(value = "/")
    public List<Orders> getOrders(@RequestParam("hotelId")int hotelId) {

        List<Orders> orders= os.getOrdersByHotelId(hotelId);
        return orders;

    }

    @PostMapping("/addorder")
    public int addOrder(@RequestBody Orders order){
        return os.save(order);
    }
}
