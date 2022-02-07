package com.example.pagination.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.pagination.api.Order;
// import com.example.pagination.api.OrderItem;
import com.example.pagination.db.OrderDao;

import org.jdbi.v3.core.Jdbi;


@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    public List<Order> orders;
    public Jdbi jdbi;
    public OrderDao orderDao;
    
    public OrderResource(OrderDao orderDao) {
        this.orderDao = orderDao;
        // this.orders = new ArrayList<Order>();
        // OrderItem order_item = new OrderItem(0, "apple", 0.5, 12);
        // List<OrderItem> order_items = new ArrayList<OrderItem>();
        // order_items.add(order_item);
        // Order order = new Order(0, 0, order_items);
        // orders.add(order);
    }

    @GET
    public List<Order> getOrders() {
        // return this.orders;
        return this.orderDao.getAll();
    }

    @GET
    @Path("{id}")
    public Order getOrderById(@PathParam("id") int id) {
        // return this.orders.get(id);
        return this.orderDao.findById(id);
    }

    @POST
    public void createOrder(int userid) {
        // this.orders.add(order);
        this.orderDao.insert(userid);
    }

}
