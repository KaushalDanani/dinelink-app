package com.example.dinelink.user;

public class QRCodeDecoder {
    int hotelId;
    int tableNo;
    QRCodeDecoder(){
        this.hotelId = 0;
        this.tableNo = 0;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }
}
