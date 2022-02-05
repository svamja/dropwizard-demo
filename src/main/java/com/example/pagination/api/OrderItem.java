package com.example.pagination.api;

public class OrderItem {
    public int id;
    public String item_name;
    public double quantity;
    public double rate;

    public OrderItem(int id, String item_name, double quantity, double rate) {
        this.id = id;
        this.item_name = item_name;
        this.quantity = quantity;
        this.rate = rate;
    }

}
