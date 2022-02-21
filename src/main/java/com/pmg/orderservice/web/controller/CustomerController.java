package com.pmg.orderservice.web.controller;

import com.pmg.model.CustomerPagedList;
import com.pmg.orderservice.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/customers/")
@RestController
public class CustomerController {

    @GetMapping
    public CustomerPagedList getAll() {
        return null;
    }

}
