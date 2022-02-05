package com.example.pagination.db;

import java.util.List;

import com.example.pagination.api.Order;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(OrderMapper.class)

public interface OrderDao {

    @SqlUpdate("create table orders(id int auto_increment primary key, userid int)")
    void createOrderTable();

    @SqlUpdate("insert into orders(userid) values (:userid)")
    void insert(@BindBean Order order);

    @SqlUpdate("update orders set userid = :order.userid where id = :order.id")
    void update(@BindBean("order") Order order);

    @SqlQuery("select * from orders where id = :id")
    Order findById(@Bind("id") int id);

    @SqlQuery("select * from orders")
    List<Order> getAll();

    @SqlUpdate("delete from orders where id = :id")
    void deleteById(@Bind int id);

}
