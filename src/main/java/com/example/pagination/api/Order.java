package com.example.pagination.api;

import java.util.ArrayList;
import java.util.List;

public class Order {
    
    public int id;
    public int userid;
    public double total;
    public List<OrderItem> items;

    public Order() {

    }

    public Order(int id, int userid, List<OrderItem> items) {
        this.id = id;
        this.userid = userid;
        this.items = items;
        this.addUp();
    }

    public Order(int id, int userid) {
        this.id = id;
        this.userid = userid;
        this.items = new ArrayList<OrderItem>();
        this.addUp();
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
