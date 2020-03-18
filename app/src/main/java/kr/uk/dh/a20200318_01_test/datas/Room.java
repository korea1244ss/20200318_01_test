package kr.uk.dh.a20200318_01_test.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String description;

    public String getFormattedPrice() {
//        상황에 따라 억 천 천인지로 가공
        if (this.price >= 10000){
            int uk = this.price / 10000;
            int thousand = this.price % 10000;

            return  String.format("%d억 %,d만원" , uk, thousand);

        }
        else {
            return String.format("%,d", this.price);
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Room(int price, String address, int floor, String description) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.description = description;



    }
}
