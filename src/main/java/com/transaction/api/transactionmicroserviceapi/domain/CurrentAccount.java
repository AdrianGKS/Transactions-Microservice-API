package com.transaction.api.transactionmicroserviceapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transaction.api.transactionmicroserviceapi.dto.CurrentAccountDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "current_accounts")
@Entity(name = "CurrentAccount")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberAccount;

    private Double balance = 0.00;

    @OneToMany(mappedBy = "originAccount")
    private List<Transaction> originTransactions;

    @OneToMany(mappedBy = "destinyAccount")
    private List<Transaction> destinyTransactions;

    @OneToOne(mappedBy = "account")
    private User user;

    public CurrentAccount(CurrentAccountDTO account) {
        numberAccount = account.numberAccount();
    }
}
