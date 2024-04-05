package com.example.dinelink.model;

import java.util.Date;
import java.util.List;

public class Orders {

    private int orderId;
    private int hotelId;
    private String userEmail;
    private Date orderDate;
    private int tableNo;
    private float totalAmount;

    public Orders() {
    }

    public Orders(int hotelId, String userEmail, Date orderDate, int tableNo, float totalAmount) {
        this.hotelId = hotelId;
        this.userEmail = userEmail;
        this.orderDate = orderDate;
        this.tableNo = tableNo;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
