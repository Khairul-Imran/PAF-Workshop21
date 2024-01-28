package com.example.day21workshopfinalised.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day21workshopfinalised.Models.Customer;
import com.example.day21workshopfinalised.Models.Order;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@Service
public class JsonService {
    
    public JsonArray customerListToJson(List<Customer> customers) {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for (Customer customer : customers) {
            JsonObject customerJson = Json.createObjectBuilder()
                .add("id", customer.getCustomerId())
                .add("companyName", customer.getCompany())
                .add("firstName", customer.getFirstName())
                .add("lastName", customer.getLastName())
                .add("jobTitle", customer.getJobTitle())
                .add("address", customer.getAddress())
                .add("city", customer.getCity())
                .add("stateProvince", customer.getStateProvince())
                .build();
            jsonArrayBuilder.add(customerJson);
        }
        JsonArray jsonCustomerArray = jsonArrayBuilder.build();

        return jsonCustomerArray;
    }

    public JsonObject customerToJson(Optional<Customer> optCustomer) {
        Customer customer = optCustomer.get();

        JsonObject customerJson = Json.createObjectBuilder()
            .add("id", customer.getCustomerId())
            .add("companyName", customer.getCompany())
            .add("firstName", customer.getFirstName())
            .add("lastName", customer.getLastName())
            .add("jobTitle", customer.getJobTitle())
            .add("address", customer.getAddress())
            .add("city", customer.getCity())
            .add("stateProvince", customer.getStateProvince())
            .build();

        return customerJson;
    }

    public JsonArray customerOrdersToJson(List<Order> orders) {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

        for (Order order : orders) {
            JsonObject orderJson = Json.createObjectBuilder()
                .add("orderId", order.getOrderId())
                .add("customerId", order.getCustomerId())
                .add("orderDate", order.getOrderDate() != null ? order.getOrderDate().toString() : "")
                .add("shippedDate", order.getOrderDate() != null ? order.getOrderDate().toString() : "")
                .add("shipToName", order.getShipToName())
                .add("address", order.getShipToAddress())
                .add("city", order.getShipToCity())
                .add("province", order.getShipToStateProvince())
                .build();
            jsonArrayBuilder.add(orderJson);
        }
        JsonArray jsonOrderArray = jsonArrayBuilder.build();

        return jsonOrderArray;
    }

}
