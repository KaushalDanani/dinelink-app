package com.dinelink.backend.service;

import com.dinelink.backend.model.Orders;
import com.dinelink.backend.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    OrdersRepository or;

    public List<Orders> getOrdersByHotelId(@RequestParam("hotelId")int hotelId){
        List<Orders> orders = or.findAllByHotelId(hotelId);
        return orders;
    }

    public int save(Orders order){
        int id = or.save(order).getOrderId();
        System.out.println("Order Id : "+id);
        return id;
    }
    public void removeOrder(@RequestParam("orderId")int orderId){
        or.deleteById(orderId);
    }

}
