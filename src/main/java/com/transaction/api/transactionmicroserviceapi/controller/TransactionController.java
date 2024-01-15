package com.transaction.api.transactionmicroserviceapi.controller;

import com.transaction.api.transactionmicroserviceapi.dto.TransactionDTO;
import com.transaction.api.transactionmicroserviceapi.dto.UserDTO;
import com.transaction.api.transactionmicroserviceapi.repository.TransactionRepository;
import com.transaction.api.transactionmicroserviceapi.repository.UserRepository;
import com.transaction.api.transactionmicroserviceapi.service.ApiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ApiServices services;

    @PostMapping("/register")
    public ResponseEntity createTransaction(@RequestBody TransactionDTO transactionDTO) {
        return services.createTransaction(transactionDTO);
    }

    @GetMapping("/consult-transaction")
    @ResponseBody
    public ResponseEntity consultTransaction() {
        return null;
    }
}
