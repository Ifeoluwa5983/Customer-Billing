package com.customerbilling.billing.repository;

import com.customerbilling.billing.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
