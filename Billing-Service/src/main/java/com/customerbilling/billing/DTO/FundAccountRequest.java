package com.customerbilling.billing.DTO;

import lombok.Data;

@Data
public class FundAccountRequest {

    private Integer customerId;

    private float amount;
}
