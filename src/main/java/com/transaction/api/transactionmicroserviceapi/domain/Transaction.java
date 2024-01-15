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

    private LocalDate date = LocalDate.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private CurrentAccount originAccount;

    @ManyToOne
    private CurrentAccount destinyAccount;


    public Transaction(TransactionDTO transactionDTO) {
        user = new User(transactionDTO.user());
        value = transactionDTO.value();
        originAccount = new CurrentAccount(transactionDTO.origin());
        destinyAccount = new CurrentAccount(transactionDTO.destiny());
    }
}