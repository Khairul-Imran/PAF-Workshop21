package com.example.day21workshopfinalised.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.day21workshopfinalised.Models.FullOrder;

@Repository
public class NorthwindRepository {
    
    @Autowired
    private JdbcTemplate template;

    // Get all customers.
    public SqlRowSet findAllCustomers(Integer limit, Integer offset) {
        return template.queryForRowSet(Queries.SQL_GET_ALL_CUSTOMERS, limit, offset);
    }

    // Get customer by id.
    public SqlRowSet findCustomerById(Integer id) {
        return template.queryForRowSet(Queries.SQL_GET_CUSTOMER_BY_ID, id);
    }

    // Get orders by customer id.
    public SqlRowSet findOrdersByCustomerId(Integer id) {
        return template.queryForRowSet(Queries.SQL_GET_ALL_ORDERS_FROM_CUSTOMER, id);
    }

    // Workshop 23.
    // Get full details by 
    public List<FullOrder> findAllOrdersById(Integer orderId) {
        return template.query(Queries.SQL_GET_FULL_ORDER_DETAILS, BeanPropertyRowMapper.newInstance(FullOrder.class), orderId);
    }
}
