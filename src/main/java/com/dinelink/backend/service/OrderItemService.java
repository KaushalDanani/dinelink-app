package com.dinelink.backend.service;

import com.dinelink.backend.model.OrderItem;
import com.dinelink.backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository oir;

    public List<OrderItem> getOrderItems(@RequestParam("orderId") int orderId) {
        List<OrderItem> orderItemList = oir.findAllByOrderId(orderId);

        return orderItemList;
    }

    public void removeOrderItems(@RequestParam("orderId")int orderId){
        oir.deleteByOrderId(orderId);
    }


}
