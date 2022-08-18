package com.customerbilling.customer.controller;

import com.customerbilling.customer.DTO.CreateCustomerRequest;
import com.customerbilling.customer.DTO.FundAccountRequest;
import com.customerbilling.customer.DTO.ResponseObject;
import com.customerbilling.customer.exception.CustomerException;
import com.customerbilling.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> registerCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) throws CustomerException {
        customerService.registerCustomer(createCustomerRequest);
        ResponseObject responseObject = new ResponseObject("Success", "Customer Created Successfully");
        return ResponseEntity.status(201).body(responseObject);
    }

    @PostMapping("/account/fund")
    public ResponseEntity<?> fundAccount(@RequestBody FundAccountRequest fundAccountRequest) throws CustomerException {
        customerService.fundAccount(fundAccountRequest);
        ResponseObject responseObject = new ResponseObject("Success", "Account funded successfully");
        return ResponseEntity.status(200).body(responseObject);
    }
}
