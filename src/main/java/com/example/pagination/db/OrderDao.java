package com.example.pagination.db;

import com.example.pagination.api.Order;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;

@RegisterRowMapper(OrderMapper.class)
public interface OrderDao {

    @SqlUpdate("create table if not exists orders (id int auto_increment primary key, userid int, total double default 0, created datetime default CURRENT_TIMESTAMP)")
    void createTable();

    @SqlUpdate("insert into orders (userid) values (:userid)")
    void insert(@Bind("userid") int userid);

    @SqlUpdate("update orders set total = :total where id = :id")
    void update(@Bind("id") int id, @Bind("total") double total);

    @SqlQuery("select * from orders where id = :id")
    Order findById(@Bind("id") int id);

    @SqlQuery("select * from orders")
    List<Order> getAll();

    @SqlQuery("select * from orders limit :limit offset :offset")
    List<Order> getPage(@Bind("offset") int offset, @Bind("limit") int limit);

    @SqlUpdate("delete from orders where id = :id")
    void deleteById(@Bind("id") int id);

    @SqlQuery("select last_insert_id();")
    public int lastInsertId();

    @SqlUpdate("drop table orders")
    void dropTable();

}
