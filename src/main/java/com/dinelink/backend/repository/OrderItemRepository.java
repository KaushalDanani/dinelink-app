package com.dinelink.backend.repository;

import com.dinelink.backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    public List<OrderItem> findAllByOrderId(int orderId);


    @Transactional
    @Modifying
    @Query("delete from OrderItem oi where oi.orderId = :orderId")
    public void deleteByOrderId(@RequestParam("orderId")int orderId);



}
