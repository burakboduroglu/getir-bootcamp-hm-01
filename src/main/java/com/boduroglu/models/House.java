package com.boduroglu.models;

public abstract class House {
    protected String name;
    protected double price;
    protected double squareMeter;
    protected int roomCount;
    protected int livingRoomCount;

    protected House(String name, double price, double squareMeter, int roomCount, int livingRoomCount) {
        this.name = name;
        this.price = price;
        this.squareMeter = squareMeter;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getSquareMeter() {
        return squareMeter;
    }
    public void setSquareMeter(double squareMeter) {
        this.squareMeter = squareMeter;
    }

    public int getRoomCount() {
        return roomCount;
    }
    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }
    public void setLivingRoomCount(int livingRoomCount) {
        this.livingRoomCount = livingRoomCount;
    }
}