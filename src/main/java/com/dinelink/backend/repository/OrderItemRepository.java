package com.dinelink.backend.repository;

import com.dinelink.backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    public List<OrderItem> findAllByOrderId(int orderId);

}
