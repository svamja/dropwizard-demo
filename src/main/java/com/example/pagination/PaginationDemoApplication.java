package com.example.pagination;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi3.JdbiFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.pagination.api.Order;
import com.example.pagination.db.OrderDao;
import com.example.pagination.resources.OrderResource;

import org.jdbi.v3.core.Jdbi;


public class PaginationDemoApplication extends Application<PaginationDemoConfiguration> {

    private static List<Order> orders;

    static {
        orders = Collections.synchronizedList(new ArrayList<Order>());
        orders.add(new Order(1, 1));
        orders.add(new Order(2, 2));
    }

    public static void main(final String[] args) throws Exception {
        if(args.length < 2) {
            new PaginationDemoApplication().run(new String[]{ "server", "config.yml" });
        }
        else {
            new PaginationDemoApplication().run(args);
        }
    }

    @Override
    public String getName() {
        return "PaginationDemo";
    }

    @Override
    public void initialize(final Bootstrap<PaginationDemoConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "index.html"));
    }

    @Override
    public void run(final PaginationDemoConfiguration config,
                    final Environment environment) 
    {

        // Create JDBC Data Source
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "database");
        
        // Create DAO Instance
        OrderDao orderDao = jdbi.onDemand(OrderDao.class);

        // Initialize Table
        orderDao.createOrderTable();

        // Seed Test Data
        seedOrders(orderDao);

        // Create REST Resource
        OrderResource orderResource = new OrderResource(orderDao);

        // Register REST Resource with Jersey
        environment.jersey().register(orderResource);
    }

    private void seedOrders(OrderDao orderDao) {
        for (Order order : orders) {
            orderDao.insert(order);
        }
    }

}
