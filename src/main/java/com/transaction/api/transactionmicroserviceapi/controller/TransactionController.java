package com.transaction.api.transactionmicroserviceapi.controller;

import com.transaction.api.transactionmicroserviceapi.dto.BasicTransactionsDTO;
import com.transaction.api.transactionmicroserviceapi.repository.TransactionRepository;
import com.transaction.api.transactionmicroserviceapi.service.APIServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
@Tag(name = "Transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private APIServices services;

    @PostMapping("/deposit/{id}")
    public ResponseEntity deposit(@PathVariable Long id, @RequestBody BasicTransactionsDTO transactionDTO) {
        return services.depositTransaction(id, transactionDTO);
    }

    @PostMapping("/withdraw/{id}")
    public ResponseEntity transaction(@PathVariable Long id, @RequestBody BasicTransactionsDTO transactionDTO) {
        return services.withdrawTransaction(id, transactionDTO);
    }

    @PostMapping("/transfer/{idOrigin}/{idDestiny}")
    public ResponseEntity transfer(@PathVariable Long idOrigin, @PathVariable Long idDestiny, @RequestBody BasicTransactionsDTO transactionDTO) {
        return services.transferTransaction(idOrigin, idDestiny, transactionDTO);
    }

    @GetMapping("/consult-transaction")
    @ResponseBody
    public ResponseEntity consultTransaction() {
        var transactions = transactionRepository.findAll();

        if(transactions.isEmpty()) {
            return ResponseEntity.badRequest().body("Sem transações identificadas.");
        }

        return ResponseEntity.ok(transactions);
    }
}
