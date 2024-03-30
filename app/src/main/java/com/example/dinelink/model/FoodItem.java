package com.example.dinelink.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodItem implements Parcelable {

    int itemId;
    int hotelId;
    String itemName;
    float itemPrice;
    String itemDesc;
    String itemCategory;
    String itemImgUrl;
    int itemQuantity = 0;

    public FoodItem(int itemId, int hotelId, String itemName, float itemPrice, String itemDesc, String itemCategory, String itemImgUrl) {
        this.itemId = itemId;
        this.hotelId = hotelId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDesc = itemDesc;
        this.itemCategory = itemCategory;
        this.itemImgUrl = itemImgUrl;
    }

    public FoodItem() {
    }

    protected FoodItem(Parcel in) {
        itemId = in.readInt();
        hotelId = in.readInt();
        itemName = in.readString();
        itemPrice = in.readFloat();
        itemDesc = in.readString();
        itemCategory = in.readString();
        itemImgUrl = in.readString();
        itemQuantity = in.readInt();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemId);
        dest.writeInt(hotelId);
        dest.writeString(itemName);
        dest.writeFloat(itemPrice);
        dest.writeString(itemDesc);
        dest.writeString(itemCategory);
        dest.writeString(itemImgUrl);
        dest.writeInt(itemQuantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
