package com.dinelink.backend.controller;

import com.dinelink.backend.model.Orders;
import com.dinelink.backend.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping(value = "/addorder")
    public Integer addOrder(@RequestBody Orders order){
        order.setOrderDate(new Date());
        System.out.println("Inside Controller.....");
        return os.save(order);
    }
    @GetMapping(value = "/remove/")
    public void removeOrder(@RequestParam("orderId")int orderId){
        os.removeOrder(orderId);
    }

}
