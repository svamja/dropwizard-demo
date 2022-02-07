package com.example.pagination.cli;

import java.util.List;

import com.example.pagination.PaginationDemoApplication;
import com.example.pagination.PaginationDemoConfiguration;
import com.example.pagination.api.Order;
import com.example.pagination.api.OrderItem;
import com.example.pagination.db.OrderDao;
import com.example.pagination.db.OrderItemDao;

import org.jdbi.v3.core.Jdbi;

import io.dropwizard.cli.EnvironmentCommand;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Environment;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;

public class DropCommand extends EnvironmentCommand<PaginationDemoConfiguration> {

    public DropCommand(PaginationDemoApplication application) {
        super(application, "drop", "drops all tables");
    }

    @Override
    public void configure(Subparser subparser) {
        super.configure(subparser);
    }

    @Override
    public void  run(Environment environment, Namespace namespace, PaginationDemoConfiguration config) 
        throws Exception 
    {
        // Create JDBC Data Source
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "jdbi");
        
        // Create DAO Instances
        OrderDao orderDao = jdbi.onDemand(OrderDao.class);
        OrderItemDao orderItemDao = jdbi.onDemand(OrderItemDao.class);

        orderDao.dropTable();
        orderItemDao.dropTable();

    }

}
