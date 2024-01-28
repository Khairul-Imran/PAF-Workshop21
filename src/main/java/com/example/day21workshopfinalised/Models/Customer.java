package com.example.day21workshopfinalised.Models;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
    Integer customerId;
    String company;
    String firstName;
    String lastName;
    String jobTitle;
    String address;
    String city;
    String stateProvince;
    List<Order> orders;

    public static Customer populate(SqlRowSet sqlRowSet) {
        final Customer customer = new Customer();
        customer.setCustomerId(sqlRowSet.getInt("id"));
        customer.setCompany(sqlRowSet.getString("company"));
        customer.setFirstName(sqlRowSet.getString("first_name"));
        customer.setLastName(sqlRowSet.getString("last_name"));
        customer.setJobTitle(sqlRowSet.getString("job_title"));
        customer.setAddress(sqlRowSet.getString("address"));
        customer.setCity(sqlRowSet.getString("city"));
        customer.setStateProvince(sqlRowSet.getString("state_province"));
        // Not sure if need to set the list of orders yet or not.
        
        return customer;
    }

}
