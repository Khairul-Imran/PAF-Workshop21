package com.example.day21workshopfinalised.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.example.day21workshopfinalised.Models.Customer;
import com.example.day21workshopfinalised.Models.FullOrder;
import com.example.day21workshopfinalised.Models.Order;
import com.example.day21workshopfinalised.Repositories.NorthwindRepository;

@Service
public class NorthwindService {
    
    @Autowired
    private NorthwindRepository northwindRepository;

    public List<Customer> findAllCustomers(Integer limit, Integer offset) {
        final List<Customer> listOfCustomers = new ArrayList<>();
        SqlRowSet rowSet = northwindRepository.findAllCustomers(limit, offset);

        while (rowSet.next()) {
            Customer customer = Customer.populate(rowSet);

            listOfCustomers.add(customer);
        }

        return (Collections.unmodifiableList(listOfCustomers));
        // or simply return listOfCustomers.
    }

    public Optional<Customer> findCustomerById(Integer id) {
        SqlRowSet rowSet = northwindRepository.findCustomerById(id);

        if (rowSet.next()) {
            return Optional.of(Customer.populate(rowSet));
        }

        throw new NoSuchElementException("Customer with ID: " + id + " not found.");
    }

    public List<Order> findOrdersByCustomerId(Integer id) {
        final List<Order> listOfOrders = new ArrayList<>();
        SqlRowSet rowSet = northwindRepository.findOrdersByCustomerId(id);

        while (rowSet.next()) {
            Order order = Order.populate(rowSet);

            listOfOrders.add(order);
        }

        return (Collections.unmodifiableList(listOfOrders));
    }

    // Workshop 23.
    // Get full orders by id.
    public List<FullOrder> findAllOrdersById(Integer id) {
        return northwindRepository.findAllOrdersById(id);
    }
}
