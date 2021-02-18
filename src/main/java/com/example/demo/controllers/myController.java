package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class myController {

    @Autowired
    private CustomerDao customerDao;

    @PostMapping("/customers")
    private int addCustomer(@RequestBody Customer customer){
        return customerDao.insert(customer);
    }
}
