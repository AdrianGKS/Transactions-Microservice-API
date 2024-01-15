package com.transaction.api.transactionmicroserviceapi.service;

import com.transaction.api.transactionmicroserviceapi.domain.Transaction;
import com.transaction.api.transactionmicroserviceapi.domain.User;
import com.transaction.api.transactionmicroserviceapi.dto.TransactionDTO;
import com.transaction.api.transactionmicroserviceapi.dto.UserDTO;
import com.transaction.api.transactionmicroserviceapi.repository.TransactionRepository;
import com.transaction.api.transactionmicroserviceapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApiServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public ResponseEntity createUser(UserDTO userDTO) {

//        if (userRepository.findByUser(userDTO) != null){
//            return ResponseEntity.badRequest().build();
//        }

        User newUser = new User(userDTO);
        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    public ResponseEntity createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction(transactionDTO);
        transactionRepository.save(transaction);

        return ResponseEntity.ok(transaction);

    }
}
