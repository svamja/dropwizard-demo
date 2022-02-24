package com.example.pagination.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.example.pagination.api.Order;
import com.example.pagination.api.OrderItem;
import com.example.pagination.db.OrderDao;
import com.example.pagination.db.OrderItemDao;

import org.jdbi.v3.core.Jdbi;


@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    public List<Order> orders;
    public Jdbi jdbi;
    public OrderDao orderDao;
    public OrderItemDao orderItemDao;
    
    public OrderResource(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        // this.orders = new ArrayList<Order>();
        // OrderItem order_item = new OrderItem(0, "apple", 0.5, 12);
        // List<OrderItem> order_items = new ArrayList<OrderItem>();
        // order_items.add(order_item);
        // Order order = new Order(0, 0, order_items);
        // orders.add(order);
    }

    @GET
    public List<Order> getOrders(@QueryParam("page") Optional<Integer> page) {
        // return this.orders;
        Integer pageValue = page.orElse(0);
        int limit = 5;
        int offset = pageValue*limit;
        List<Order> orders = this.orderDao.getPage(offset, limit);
        for(Order order: orders) {
            order.setItems(this.orderItemDao.byOrderId(order.id));
        }
        return orders;
    }

    @GET
    @Path("{id}")
    public Order getOrderById(@PathParam("id") int id) {
        // return this.orders.get(id);
        Order order = this.orderDao.findById(id);
        List<OrderItem> items = orderItemDao.byOrderId(id);
        order.setItems(items);
        return order;
    }

    @GET
    @Path("items")
    public List<OrderItem> getItems() {
        List<OrderItem> items = this.orderItemDao.getAll();
        return items;
    }

    @POST
    public void createOrder(Order order) {
        this.orderDao.insert(order.userid);
        int order_id = this.orderDao.lastInsertId();
        for(OrderItem item: order.items) {
            item.setOrderId(order_id);
            // this.orderItemDao.insert(item);
            this.orderItemDao.insert(item.order_id, item.name, item.quantity, item.rate);
        }
    }

    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") int id) {
        this.orderDao.deleteById(id);
    }

}
