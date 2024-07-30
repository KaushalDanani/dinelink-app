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

    public Orders(int hotelId, String userEmail, Date orderDate, int tableNo, float totalAmount) {
        this.hotelId = hotelId;
        this.userEmail = userEmail;
        this.orderDate = orderDate;
        this.tableNo = tableNo;
        this.totalAmount = totalAmount;
    }
}
