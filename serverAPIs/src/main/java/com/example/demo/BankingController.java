package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@RestController
public class BankingController {

    @Autowired
    private UsersRepository repository; // need help with this as I've created the validation but it's throwing errors :)

    /** Basic permissions */


    /**
     * All HTTP Requests with regards to Transactions
     */

    @GetMapping(value = {"/banking"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String getTransactions() {
        return ("{\"message\":\"Displays list of transactions\"}");
    }
    // View Recent Transactions

    @PostMapping("banking/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    String createTransaction(@RequestBody Banking transaction, HttpServletResponse response) {
        if (1==repository.create(transaction)) {
            return "{message:\"success\"}";
        } else {
            response.setStatus(404); // TODO - proper error handling
            return "{error:\"not found\"}";
        }
    }
    // Creates New Transaction

    /**
     * All HTTP Requests with regards to Standing Orders
     */

    @GetMapping(value = {"/standingOrders"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String getStandingOrder() {
        return ("{\"message\":\"Displays list of standing orders\"}");
    }
    // Obtains Standing Orders

    @PostMapping("/standingOrders")
    @ResponseStatus(HttpStatus.CREATED)
    String createStandingOrder(@RequestBody Banking standingOrder, HttpServletResponse response) {
        if (1==repository.create(standingOrder)) {
            return "{message:\"standing order created\"}";
        } else {
            response.setStatus(404); // TODO - proper error handling
            return "{error:\"standing order not created\"}";
        }
    }
    // Creates New Standing Orders

    @DeleteMapping("//standingOrder/{id}")
    String deleteStandingOrder(@PathVariable String standingOrder,  HttpServletResponse response) {
        if (1==repository.delete(standingOrder)) {
            return "{message:\"Standing orders successfully deleted\"}";
        } else {
            response.setStatus(404); // TODO - proper error handling
            return "{error:\"No standing orders found\"}";
        }
        // Creates New Standing Orders
    }
}
