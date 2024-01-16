package com.transaction.api.transactionmicroserviceapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transaction.api.transactionmicroserviceapi.dto.BasicTransactionsDTO;
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
    private User user;

    public Transaction(User originAccount, User destinyAccount, BasicTransactionsDTO transactionDTO) {
        value = transactionDTO.value();
        date = LocalDate.now();
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
    }

    public Transaction(User user, BasicTransactionsDTO transactionDTO) {
        this.user = user;
        value = transactionDTO.value();
        date = LocalDate.now();
    }

}