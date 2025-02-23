package com.preworkspringredis.controllers;

import com.preworkspringredis.dto.CustomerDto;
import com.preworkspringredis.dto.TestDto;
import com.preworkspringredis.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomers() {
            return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto) {
        var result = customerService.addCustomer(customerDto);
        return ResponseEntity.ok(result);
    }
}
