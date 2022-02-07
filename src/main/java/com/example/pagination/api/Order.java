package com.example.pagination.api;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    
    public int id;
    public int userid;
    public double total;
    public Date created;
    public List<OrderItem> items;

    public Order() {

    }

    public Order(int id, int userid, double total, Date created) {
        this.id = id;
        this.userid = userid;
        this.total = total;
        this.created = created;
        this.items = new ArrayList<OrderItem>();
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public double getTotal() {
        return total;
    }

    public Date getCreated() {
        return created;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        this.addUp();
    }

    public void addUp() {
        double total = 0;
        for(OrderItem item: items) {
            total += item.quantity * item.rate;
        }
        this.total = total;
    }

}
