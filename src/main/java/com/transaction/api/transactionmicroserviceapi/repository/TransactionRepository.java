package com.transaction.api.transactionmicroserviceapi.repository;

import com.transaction.api.transactionmicroserviceapi.domain.Transaction;
import com.transaction.api.transactionmicroserviceapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
