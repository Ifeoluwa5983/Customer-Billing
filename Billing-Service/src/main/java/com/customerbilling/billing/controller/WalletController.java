package com.customerbilling.billing.controller;

import com.customerbilling.billing.DTO.FundAccountRequest;
import com.customerbilling.billing.service.WalletService;
import exception.BillingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/wallets")
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/{customerId}")
    public String createAccount(@PathVariable Integer customerId){
        walletService.createWallet(customerId);
        return ("Account created successfully");
    }

    @PostMapping("/")
    public String fundAccount(@RequestBody FundAccountRequest fundAccountRequest) throws BillingException {
        walletService.fundAccount(fundAccountRequest);
        return ("Account created successfully");
    }
}
