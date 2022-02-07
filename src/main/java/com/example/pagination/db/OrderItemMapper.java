package com.example.pagination.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.pagination.api.OrderItem;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
  
public class OrderItemMapper implements RowMapper<OrderItem>{

  @Override
  public OrderItem map(ResultSet rs, StatementContext ctx) throws SQLException {
    return new OrderItem(
        rs.getInt("id"), rs.getInt("order_id"), 
        rs.getString("name"),
        rs.getDouble("quantity"), rs.getDouble("rate")
    );
  }

}


