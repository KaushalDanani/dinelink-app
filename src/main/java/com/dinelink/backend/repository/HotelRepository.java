package com.dinelink.backend.repository;

import com.dinelink.backend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;


@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    @Transactional
    @Modifying
    @Query("update Hotel h set h.hotel_ip = :hotel_ip where h.hotel_id = :hotel_id")
    void setIp(@RequestParam("hotel_ip")String hotel_ip,
                       @RequestParam("hotel_id")int hotel_id);

}
