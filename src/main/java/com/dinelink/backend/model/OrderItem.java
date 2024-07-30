package com.dinelink.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    int orderItemId;

    @Column
    int orderId;

    @Column
    int itemId;

    @Column
    int itemQuantity;

    public OrderItem(int orderId, int itemId, int itemQuantity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }
}
