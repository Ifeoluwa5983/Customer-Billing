package com.customerbilling.billing.service;

import com.customerbilling.billing.DTO.FundAccountRequest;
import com.customerbilling.billing.model.Status;
import com.customerbilling.billing.model.Transaction;
import com.customerbilling.billing.model.Wallet;
import com.customerbilling.billing.repository.TransactionRepository;
import com.customerbilling.billing.repository.WalletRepository;
import exception.BillingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RabbitProducerService rabbitProducerService;

        public void createWallet(Integer customerId){
        Wallet wallet = Wallet.builder()
                .balance(0)
                .createdDate(LocalDate.now().toString())
                .customerId(customerId)
                .build();
        walletRepository.save(wallet);
    }

    public void fundAccount(FundAccountRequest fundAccountRequest) throws BillingException {
        try {
            Wallet wallet = walletRepository.findByCustomerId(fundAccountRequest.getCustomerId());
            Transaction transaction = Transaction.builder()
                    .amount(fundAccountRequest.getAmount())
                    .accountId(wallet.getId())
                    .balance(wallet.getBalance() + fundAccountRequest.getAmount())
                    .createdDate(LocalDate.now().toString())
                    .status(Status.PENDING.toString())
                    .build();
            transactionRepository.save(transaction);
            rabbitProducerService.sendMessage(transaction);
            transaction.setStatus(Status.COMPLETED.toString());
            transactionRepository.save(transaction);
            wallet.setBalance(transaction.getBalance());
            wallet.setUpdatedDate(LocalDate.now().toString());
            walletRepository.save(wallet);
        }catch (Exception exception){
            throw new BillingException("An error occured while try to fund your account");
        }
    }
}
