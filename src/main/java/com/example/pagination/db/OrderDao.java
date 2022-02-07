package com.example.pagination.db;

import com.example.pagination.api.Order;

// import org.skife.jdbi.v2.sqlobject.Bind;
// import org.skife.jdbi.v2.sqlobject.BindBean;
// import org.skife.jdbi.v2.sqlobject.SqlQuery;
// import org.skife.jdbi.v2.sqlobject.SqlUpdate;
// import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import org.jdbi.v3.sqlobject.customizer.Bind;
// import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;

import java.util.List;

@RegisterRowMapper(OrderMapper.class)
public interface OrderDao {
    @SqlUpdate("create table ORDERS (id int auto_increment primary key, userid int)")
    void createOrderTable();

    @SqlUpdate("insert into ORDERS (userid) values (:userid)")
    void insert(@Bind("userid") int userid);

    @SqlUpdate("update ORDERS set userid = :p.userid where id = :p.id")
    void update(@Bind("id") int id, @Bind("userid") int userid);

    @SqlQuery("select * from ORDERS where id = :id")
    Order findById(@Bind("id") int id);

    @SqlQuery("select * from ORDERS")
    List<Order> getAll();

    @SqlUpdate("delete from ORDERS where id = :id")
    void deleteById(@Bind int id);

}
