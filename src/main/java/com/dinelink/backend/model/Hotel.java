package com.dinelink.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Entity
@NoArgsConstructor
public class Hotel {

    @GeneratedValue
    @Id
    private int hotel_id;
    @Column
    private String hotel_name;
    @Column
    private String hotel_password;
    @Column
    private String hotel_addr;
    @Column
    private Double hotel_x_coords;
    @Column
    private Double hotel_y_coords;
    @Column
    private float hotel_rating;
    @Column
    private String hotel_link;
    @Column
    private Blob hotel_image;
    @Column
    private String hotel_ip;

    public Hotel(String hotel_name, String hotel_password, String hotel_addr, Double hotel_x_coords, Double hotel_y_coords, float hotel_rating, String hotel_link, Blob hotel_image, String hotel_ip) {
        this.hotel_name = hotel_name;
        this.hotel_password = hotel_password;
        this.hotel_addr = hotel_addr;
        this.hotel_x_coords = hotel_x_coords;
        this.hotel_y_coords = hotel_y_coords;
        this.hotel_rating = hotel_rating;
        this.hotel_link = hotel_link;
        this.hotel_image = hotel_image;
        this.hotel_ip = hotel_ip;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_password() {
        return hotel_password;
    }

    public void setHotel_password(String hotel_password) {
        this.hotel_password = hotel_password;
    }

    public String getHotel_addr() {
        return hotel_addr;
    }

    public void setHotel_addr(String hotel_addr) {
        this.hotel_addr = hotel_addr;
    }

    public Double getHotel_x_coords() {
        return hotel_x_coords;
    }

    public void setHotel_x_coords(Double hotel_x_coords) {
        this.hotel_x_coords = hotel_x_coords;
    }

    public Double getHotel_y_coords() {
        return hotel_y_coords;
    }

    public void setHotel_y_coords(Double hotel_y_coords) {
        this.hotel_y_coords = hotel_y_coords;
    }

    public float getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(float hotel_rating) {
        this.hotel_rating = hotel_rating;
    }

    public String getHotel_link() {
        return hotel_link;
    }

    public void setHotel_link(String hotel_link) {
        this.hotel_link = hotel_link;
    }

    public Blob getHotel_image() {
        return hotel_image;
    }

    public void setHotel_image(Blob hotel_image) {
        this.hotel_image = hotel_image;
    }

    public String getHotel_ip() {
        return hotel_ip;
    }

    public void setHotel_ip(String hotel_ip) {
        this.hotel_ip = hotel_ip;
    }
}
