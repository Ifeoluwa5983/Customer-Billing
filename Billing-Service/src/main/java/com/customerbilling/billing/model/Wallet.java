package com.customerbilling.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Wallet {

    @Id
    @SequenceGenerator(
            name = "wallet_id_sequence",
            sequenceName = "wallet_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wallet_id_sequence"
    )
    private Integer id;

    private Integer customerId;

    private float balance;

    private String createdDate;

    private String updatedDate;
}
