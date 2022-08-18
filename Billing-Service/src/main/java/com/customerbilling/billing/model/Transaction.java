package com.customerbilling.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "billing_transaction")
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "billing_transaction_id_sequence",
            sequenceName = "billing_transaction_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "billing_transaction_id_sequence"
    )
    private Integer id;

    private Integer accountId;

    private float amount;

    private float balance;

    private String status;

    private String createdDate;
}
