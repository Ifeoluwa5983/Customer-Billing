package com.customerbilling.billing.repository;

import com.customerbilling.billing.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    Wallet findByCustomerId(Integer customerId);
}
