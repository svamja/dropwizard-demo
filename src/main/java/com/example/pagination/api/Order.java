package com.example.pagination.api;

import java.util.List;

public class Order {
    
    public int id;
    public int user_id;
    public double total;
    public List<OrderItem> items;

    public Order() {

    }

    public Order(int id, int user_id, List<OrderItem> items) {
        this.id = id;
        this.user_id = user_id;
        this.items = items;
        this.addUp();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public void addUp() {
        double total = 0;
        for(OrderItem item: items) {
            total += item.quantity * item.rate;
        }
        this.total = total;
    }

}
