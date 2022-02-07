package com.example.pagination.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.pagination.api.Order;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
  
public class OrderMapper implements RowMapper<Order>{

  @Override
  public Order map(ResultSet rs, StatementContext ctx) throws SQLException {
    return new Order(rs.getInt("id"), rs.getInt("userid"), rs.getDouble("total"), rs.getTimestamp("created") );
  }

}


