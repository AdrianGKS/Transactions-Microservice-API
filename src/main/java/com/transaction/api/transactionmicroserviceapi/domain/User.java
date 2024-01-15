package com.transaction.api.transactionmicroserviceapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.transaction.api.transactionmicroserviceapi.dto.CreateUserDTO;
import com.transaction.api.transactionmicroserviceapi.dto.TransactionDTO;
import com.transaction.api.transactionmicroserviceapi.dto.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "users")
    private List<Transaction> transactions;

    public User(UserDTO userDTO) {
        id = userDTO.id();
        name = userDTO.name();
        numberAccount = userDTO.numberAccount();
        balance = userDTO.balance();
    }

    public User(CreateUserDTO userDTO) {
        name = userDTO.name();
        numberAccount = userDTO.numberAccount();

        if (userDTO.balance() == null || userDTO.balance() < 0)
            balance = 0.0;
    }

}
