package com.dinelink.backend.repository;

import com.dinelink.backend.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {

    public List<FoodItem> findAllByHotelId(int hotelId);
}
