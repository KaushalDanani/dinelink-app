package com.dinelink.backend.model.hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepository extends CrudRepository<Hotel,String> {
}
