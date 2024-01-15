package com.transaction.api.transactionmicroserviceapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private CurrentAccount account;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    public User(UserDTO userDTO) {
        name = userDTO.name();
        account = new CurrentAccount(userDTO.account());
    }



}
