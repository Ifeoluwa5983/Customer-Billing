package com.customerbilling.customer.DTO;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String firstName;

    private String lastName;

    private String phoneNumber;
}
