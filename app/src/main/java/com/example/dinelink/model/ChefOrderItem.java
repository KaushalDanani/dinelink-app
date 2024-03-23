package com.example.dinelink.model;

public class ChefOrderItem {

    private String item_name;
    private int item_quantity;


    public ChefOrderItem(String item_name, int item_quantity) {
        this.item_name = item_name;
        this.item_quantity = item_quantity;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
}
