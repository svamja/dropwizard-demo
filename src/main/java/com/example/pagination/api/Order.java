package com.example.pagination.api;

import java.util.List;

public class Order {
    
    public int id;
    public int user_id;
    public double total;
    public List<OrderItem> order_items;

    public Order() {

    }

    public Order(int id, int user_id, List<OrderItem> order_items) {
    // public Order(int id, int user_id) {
        this.id = id;
        this.user_id = user_id;
        this.order_items = order_items;
        this.addUp();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addUp() {
        double total = 0;
        for(OrderItem item: order_items) {
            total += item.quantity * item.rate;
        }
        this.total = total;
    }

}
