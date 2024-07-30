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

    public FoodItem(int hotelId, String itemName, float itemPrice, String itemDesc, String itemCategory, String itemImgUrl) {
        this.hotelId = hotelId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.itemCategory = itemCategory;
        this.itemImgUrl = itemImgUrl;
    }

    @Column
    String itemCategory;

    @Column
    String itemImgUrl;
}
