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
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {

    @Id
    @GeneratedValue
    @Column
    int itemId;

    @Column
    int hotelId;

    @Column
    String itemName;

    @Column
    float itemPrice;

    @Column
    String itemDesc;

    @Column
    String itemCategory;

    @Column
    String itemImgUrl;
}
