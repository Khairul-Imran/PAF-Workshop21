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

    // Additions for Workshop 23.
    public static final String SQL_GET_FULL_ORDER_DETAILS = """
        SELECT 
                o.id, 
                o.order_date, 
                o.customer_id AS customerID, 
                (od.quantity * od.unit_price * (1 - od.discount)) AS total_price, 
                (od.quantity * p.standard_cost) AS cost_price
        FROM 
                orders AS o
                INNER JOIN order_details AS od ON o.id = od.order_id
                INNER JOIN products AS p ON od.product_id = p.id
        WHERE o.id = ?
        """;
}
