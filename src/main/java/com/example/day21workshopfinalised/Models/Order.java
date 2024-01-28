package com.example.day21workshopfinalised.Models;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    
    Integer orderId;
    Integer customerId;
    DateTime orderDate;
    DateTime shippedDate;
    String shipToName;
    String shipToAddress;
    String shipToCity;
    String shipToStateProvince;

    public static Order populate(SqlRowSet sqlRowSet) {
        final Order order = new Order();
        order.setOrderId(sqlRowSet.getInt("id"));
        order.setCustomerId(sqlRowSet.getInt("customer_id"));
        // Dates, use getString.
        order.setOrderDate(new DateTime(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm").parseDateTime(sqlRowSet.getString("order_date"))));
        if (sqlRowSet.getString("shipped_date") != null) {
            order.setShippedDate(new DateTime(DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm").parseDateTime(sqlRowSet.getString("shipped_date"))));
        }
        order.setShipToName(sqlRowSet.getString("ship_name"));
        order.setShipToAddress(sqlRowSet.getString("ship_address"));
        order.setShipToCity(sqlRowSet.getString("ship_city"));
        order.setShipToStateProvince(sqlRowSet.getString("ship_state_province"));

        return order;
    }

}
