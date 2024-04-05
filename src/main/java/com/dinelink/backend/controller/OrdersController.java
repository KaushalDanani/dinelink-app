package com.dinelink.backend.controller;

import com.dinelink.backend.model.Orders;
import com.dinelink.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/remove/")
    public void removeOrder(@RequestParam("orderId")int orderId){
        os.removeOrder(orderId);
    }

}
