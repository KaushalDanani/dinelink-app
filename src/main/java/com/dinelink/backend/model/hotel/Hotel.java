package com.dinelink.backend.model.hotel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Blob;

@Entity
public class Hotel {

    @Id
    private int hotel_id;
    private String hotel_name;
    private String hote_password;
    private String hotel_addr;
    private Double hotel_x_coords;
    private Double Hotel_y_coords;
    private int hotel_rating;
    private String hotel_link;
    private Blob hotel_image;
    private String hotel_ip;

    public String getHotel_ip() {
        return hotel_ip;
    }

    public void setHotel_ip(String hotel_ip) {
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

    public String getHote_password() {
        return hote_password;
    }

    public void setHote_password(String hote_password) {
        this.hote_password = hote_password;
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
        return Hotel_y_coords;
    }

    public void setHotel_y_coords(Double hotel_y_coords) {
        Hotel_y_coords = hotel_y_coords;
    }

    public int getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(int hotel_rating) {
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


}
