package com.transaction.api.transactionmicroserviceapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transaction.api.transactionmicroserviceapi.dto.TransactionDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "transactions")
@Entity(name = "Transaction")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "origin_account_id")
    private User originAccount;

    @ManyToOne
    @JoinColumn(name = "destiny_account_id")
    private User destinyAccount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    public Transaction(TransactionDTO transactionDTO) {
        value = transactionDTO.value();
        date = LocalDate.now();
        originAccount = new User(transactionDTO.origin());
        destinyAccount = new User(transactionDTO.destiny());
    }

}