package com.transaction.api.transactionmicroserviceapi.service;

import com.transaction.api.transactionmicroserviceapi.domain.Transaction;
import com.transaction.api.transactionmicroserviceapi.domain.User;
import com.transaction.api.transactionmicroserviceapi.dto.CreateUserDTO;
import com.transaction.api.transactionmicroserviceapi.dto.BasicTransactionsDTO;
import com.transaction.api.transactionmicroserviceapi.repository.TransactionRepository;
import com.transaction.api.transactionmicroserviceapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class APIServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public ResponseEntity createUser(CreateUserDTO userDTO) {
        User newUser = new User(userDTO);
        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    public ResponseEntity depositTransaction(Long id, BasicTransactionsDTO transactionDTO) {
        var user = userRepository.getReferenceById(id);
        user.deposit(transactionDTO);
        var transaction = new Transaction(user, transactionDTO);

        userRepository.save(user);
        transactionRepository.save(transaction);

        return ResponseEntity.ok(transaction);
    }

    public ResponseEntity withdrawTransaction(Long id, BasicTransactionsDTO transactionDTO) {
        var user = userRepository.getReferenceById(id);
        user.withdraw(transactionDTO);
        var transaction = new Transaction(user, transactionDTO);

        userRepository.save(user);
        transactionRepository.save(transaction);

        return ResponseEntity.ok(transaction);
    }

    public ResponseEntity transferTransaction(Long idOrigin, Long idDestiny, BasicTransactionsDTO transactionDTO) {
        var userOrigin = userRepository.getReferenceById(idOrigin);
        var userDestiny = userRepository.getReferenceById(idDestiny);

        userOrigin.withdraw(transactionDTO);
        userDestiny.deposit(transactionDTO);

        var transaction = new Transaction(userOrigin, userDestiny, transactionDTO);

        transactionRepository.save(transaction);
        userRepository.save(userOrigin);
        userRepository.save(userDestiny);

        return ResponseEntity.ok(transaction);
    }
}
