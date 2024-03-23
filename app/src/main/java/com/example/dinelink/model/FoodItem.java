package com.example.dinelink.model;

public class FoodItem {

    int item_id;
    int hotel_id;
    String item_name;
    float item_price;
    String item_desc;
    String item_category;
    String img_url;

    int item_quantity=0;

    public FoodItem(int item_id, int hotel_id, String item_name, float item_price, String item_desc, String item_category, String img_url) {
        this.item_id = item_id;
        this.hotel_id = hotel_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_desc = item_desc;
        this.item_category = item_category;
        this.img_url = img_url;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }
}
