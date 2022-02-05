package com.example.pagination.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.pagination.api.Order;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class OrderMapper implements ResultSetMapper<Order> {

    @Override
    public Order map(int i, ResultSet rs, StatementContext ctx)
        throws SQLException
    {
      return new Order(rs.getInt("id"), rs.getInt("userid"));
    }
  }
  
  