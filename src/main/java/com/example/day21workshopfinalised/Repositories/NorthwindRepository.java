package com.example.day21workshopfinalised.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

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

}
