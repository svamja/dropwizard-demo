package com.example.pagination.db;

import com.example.pagination.api.OrderItem;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;

@RegisterRowMapper(OrderItemMapper.class)
public interface OrderItemDao {
    @SqlUpdate("create table if not exists order_items (id int auto_increment primary key, order_id int, name varchar(255), quantity double, rate double)")
    void createTable();

    // @SqlUpdate("insert into order_items (order_id, name, quantity, rate) values (:item.order_id, :item.name, :item.quantity, :item.rate)")
    // void insert(@BindBean("item") OrderItem item);

    // @SqlUpdate("insert into order_items (order_id, name, quantity, rate) values (:order_id, :name, :quantity, :rate)")
    // void insert(@BindBean OrderItem item);

    @SqlUpdate("insert into order_items (order_id, name, quantity, rate) values (:order_id, :name, :quantity, :rate)")
    void insert(@Bind("order_id") int order_id, @Bind("name") String name, @Bind("quantity") double quantity, @Bind("rate") double rate);

    @SqlUpdate("update order_items set order_item = :order_item, name = :name, quantity = :quantity, rate = :rate where id = :id")
    void update(@BindBean OrderItem item);

    @SqlQuery("select * from order_items where id = :id")
    OrderItem findById(@Bind("id") int id);

    @SqlQuery("select * from order_items")
    List<OrderItem> getAll();

    @SqlQuery("select * from order_items where order_id = :order_id")
    List<OrderItem> byOrderId(@Bind("order_id") int order_id);

    @SqlUpdate("delete from order_items where id = :id")
    void deleteById(@Bind int id);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();

    @SqlUpdate("drop table order_items")
    void dropTable();
  
}
