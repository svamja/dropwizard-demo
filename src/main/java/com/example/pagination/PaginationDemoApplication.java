package com.example.pagination;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.assets.AssetsBundle;

import com.example.pagination.resources.OrderResource;


public class PaginationDemoApplication extends Application<PaginationDemoConfiguration> {

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
    public void run(final PaginationDemoConfiguration configuration,
                    final Environment environment) {
        
        OrderResource orderResource = new OrderResource();
        environment.jersey().register(orderResource);
    }

}
