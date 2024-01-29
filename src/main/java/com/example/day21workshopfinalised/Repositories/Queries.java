package com.example.day21workshopfinalised.Repositories;

public class Queries {
    
    public static final String SQL_GET_ALL_CUSTOMERS = """
            select * from customers limit ? offset ?
            """;

    public static final String SQL_GET_CUSTOMER_BY_ID = """
            select * from customers where id = ?
            """;

    public static final String SQL_GET_ALL_ORDERS_FROM_CUSTOMER = """
            select * from orders where customer_id = ?
            """;

    // Might add more queries to experiment with.
}
