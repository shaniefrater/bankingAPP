package com.example.demo;

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

    @PostMapping(value = {"/banking/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String createTransaction(@Valid @RequestBody Banking transaction, HttpServletResponse response) {
        return ("{\"message\":\"Please fill out the details accordingly\"}");
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

    @PostMapping(value = {"/standingOrder/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String createStandingOrder() {
        return ("{\"message\":\"Creates new standing order\"}");
    }
    // Creates New Standing Orders

    @DeleteMapping(value = {"/standingOrders"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    String deleteStandingOrders() {
        return ("{\"message\":\"Deleted all standing orders\"}");
    }
    // Deletes all Standing Orders
}
