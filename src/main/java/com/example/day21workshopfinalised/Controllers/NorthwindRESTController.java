package com.example.day21workshopfinalised.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day21workshopfinalised.Models.Customer;
import com.example.day21workshopfinalised.Models.Order;
import com.example.day21workshopfinalised.Services.JsonService;
import com.example.day21workshopfinalised.Services.NorthwindService;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class NorthwindRESTController {
    
    @Autowired
    private NorthwindService northwindService;

    @Autowired
    private JsonService jsonService;

    @GetMapping(path = "/customers")
    public ResponseEntity<String> getAllCustomers(
            @RequestParam(required = false, defaultValue = "5") Integer limit, 
            @RequestParam(required = false, defaultValue = "0") Integer offset) {
        // Wonder if Integer works or not?
        List<Customer> listOfCustomers = northwindService.findAllCustomers(limit, offset);
        JsonArray jsonCustomerArray = jsonService.customerListToJson(listOfCustomers);
        String jsonCustomerArrayString = jsonCustomerArray.toString();

        if (jsonCustomerArray.isEmpty()) {
            return ResponseEntity.status(404).body(
                Json.createObjectBuilder().add("Message: ", "Cannot find customers.").build().toString()
            );
        }

        return ResponseEntity.ok(jsonCustomerArrayString);
    }

    @GetMapping(path = "/customer/{customerId}")
    public ResponseEntity<String> getCustomerById(@PathVariable Integer customerId) {
        Optional<Customer> customer = northwindService.findCustomerById(customerId);
        JsonObject jsonCustomer = jsonService.customerToJson(customer);
        String jsonCustomerString = jsonCustomer.toString();

        if (jsonCustomer.isEmpty()) {
            return ResponseEntity.status(404).body(
                Json.createObjectBuilder().add("Message: ", "Cannot find " + customerId).build().toString()
            );
        }
        
        return ResponseEntity.ok(jsonCustomerString);
    }

    @GetMapping(path = "/customer/{customerId}/orders")
    public ResponseEntity<String> getOrdersById(@PathVariable Integer customerId) {
        List<Order> listOfOrders = northwindService.findOrdersByCustomerId(customerId);
        JsonArray jsonOrdersArray = jsonService.customerOrdersToJson(listOfOrders);
        String jsonOrdersArrayString = jsonOrdersArray.toString();

        if (jsonOrdersArray.isEmpty()) {
            return ResponseEntity.status(404).body(
                Json.createObjectBuilder().add("Message: ", "Cannot find orders for customer " + customerId + ".").build().toString()
            );
        }

        return ResponseEntity.ok(jsonOrdersArrayString);
    }


}
