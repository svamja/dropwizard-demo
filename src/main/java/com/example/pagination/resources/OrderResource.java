package com.example.pagination.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.pagination.api.Order;
import com.example.pagination.api.OrderItem;


@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    public List<Order> orders;
    
    public OrderResource() {
        this.orders = new ArrayList<Order>();
        OrderItem order_item = new OrderItem(0, "apple", 0.5, 12);
        List<OrderItem> order_items = new ArrayList<OrderItem>();
        order_items.add(order_item);
        Order order = new Order(0, 0, order_items);
        orders.add(order);
    }

    @GET
    public List<Order> getOrders() {
        return this.orders;
    }

    @GET
    @Path("{id}")
    public Order getOrderById(@PathParam("id") int id) {
        return this.orders.get(id);
    }

    @POST
    public void createOrder(Order order) {
        this.orders.add(order);
    }

}
