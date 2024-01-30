package com.example.day21workshopfinalised.Models;

import java.sql.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullOrder {
    
    int id;
    Date orderDate;
    int customerId;
    Double totalPrice;
    Double costPrice;

    // Didn't use populate in this case. Used BeanPropertyRowMapper instead.
    public static FullOrder populate(SqlRowSet sqlRowSet) {
        final FullOrder fullOrder = new FullOrder();

        fullOrder.setId(sqlRowSet.getInt("id"));
        fullOrder.setOrderDate(sqlRowSet.getDate("order_date"));
        fullOrder.setCustomerId(sqlRowSet.getInt("customerID"));
        fullOrder.setTotalPrice(sqlRowSet.getDouble("total_price"));
        fullOrder.setCostPrice(sqlRowSet.getDouble("cost_price"));
        
        return fullOrder;
    }

}
