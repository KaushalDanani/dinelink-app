package com.dinelink.backend.repository;

import com.dinelink.backend.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    public List<Orders> findAllByHotelId(int hotelId);

}
