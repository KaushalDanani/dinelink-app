package com.dinelink.backend.controller;

import com.dinelink.backend.model.OrderItem;
import com.dinelink.backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItems")
public class OrderItemController {

    @Autowired
    OrderItemService ois;

    @GetMapping(value = "/")
    List<OrderItem> getOrderItems(@RequestParam("orderId")int orderId)
    {
        List<OrderItem> orderItems = ois.getOrderItems(orderId);
        return orderItems;
    }

}
