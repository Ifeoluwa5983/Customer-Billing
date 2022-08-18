package com.customerbilling.customer.service;

import com.customerbilling.customer.DTO.CreateCustomerRequest;

import com.customerbilling.customer.DTO.FundAccountRequest;
import com.customerbilling.customer.exception.CustomerException;
import com.customerbilling.customer.model.Customer;
import com.customerbilling.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Value("${app.host}")
    private String host;

    private final RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void registerCustomer(CreateCustomerRequest createCustomerRequest) throws CustomerException {
        try {
            Customer customer = new Customer();
            modelMapper.map(createCustomerRequest, customer);
            customer.setCreatedDate(LocalDate.now());
            customerRepository.save(customer);
            restTemplate.getForObject("http://" + host + ":7000/api/v1/wallets/{customerId}", String.class, customer.getId());

        }
        catch (Exception exception){
            throw new CustomerException("An error occurred in account creation");
        }
    }

    public void fundAccount(FundAccountRequest fundAccountRequest) throws CustomerException {
        try {
            restTemplate.postForObject("http://" + host + ":7000/api/v1/wallets/", fundAccountRequest, String.class);
        }catch (Exception exception){
            throw new CustomerException("An error occurred in account funding");
        }

    }
}
