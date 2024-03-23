package com.example.dinelink.model;

import java.util.List;

public class Order {

    private List<ChefOrderItem> orderItemList;
    private int table;

    public Order(List<ChefOrderItem> orderItemList, int table) {
        this.orderItemList = orderItemList;
        this.table = table;
    }

    public List<ChefOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<ChefOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }
}
