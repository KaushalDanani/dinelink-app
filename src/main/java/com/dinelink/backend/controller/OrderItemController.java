package com.dinelink.backend.controller;

import com.dinelink.backend.model.OrderItem;
import com.dinelink.backend.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/remove/")
    void  removeOrderItems(@RequestParam("orderId")int orderId)
    {
        ois.removeOrderItems(orderId);
    }

    @PostMapping(value = "/addOrderItems/")
    void addOrderItems(@RequestBody List<OrderItem> orderItems) {
        ois.save(orderItems);
    };

}
