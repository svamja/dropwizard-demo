package com.example.pagination.api;

public class OrderItem {

    public int id;
    public int order_id;
    public String name;
    public double quantity;
    public double rate;

    public OrderItem(int id, int order_id, String name, double quantity, double rate) {
        this.id = id;
        this.order_id = order_id;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
    }

    public OrderItem() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
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

    public int getId() {
        return this.id;
    }

    public int getOrderId() {
        return this.order_id;
    }

    public String getName() {
        return this.name;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public double getRate() {
        return this.rate;
    }

}
