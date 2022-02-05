package com.example.pagination.api;

public class OrderItem {
    public int id;
    public String name;
    public double quantity;
    public double rate;

    public OrderItem(int id, String name, double quantity, double rate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
    }

    public OrderItem() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}
