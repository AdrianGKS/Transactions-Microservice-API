package com.transaction.api.transactionmicroserviceapi.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transaction.api.transactionmicroserviceapi.dto.*;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "User")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String numberAccount;

    private Double balance;


    public User(UserDTO userDTO) {
        id = userDTO.id();
        name = userDTO.name();
        numberAccount = userDTO.numberAccount();
        balance = userDTO.balance();
    }

    public User(CreateUserDTO userDTO) {
        name = userDTO.name();
        numberAccount = userDTO.numberAccount();
        balance = 0.00;
    }


    public void deposit(BasicTransactionsDTO transactionDTO) {
        if (transactionDTO != null) {
            balance += transactionDTO.value();
        }
    }

    public void withdraw(BasicTransactionsDTO transactionDTO) {
        if (transactionDTO != null) {
            balance -= transactionDTO.value();
        }
    }


}
