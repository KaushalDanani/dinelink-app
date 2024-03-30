package com.dinelink.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue
    int orderId;

    @Column
    int hotelId;

    @Column
    String userEmail;

    @Column
    Date orderDate;

    @Column
    int tableNo;

    @Column
    float totalAmount;


}
