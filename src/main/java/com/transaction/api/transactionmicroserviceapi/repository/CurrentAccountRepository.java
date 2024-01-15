package com.transaction.api.transactionmicroserviceapi.repository;

import com.transaction.api.transactionmicroserviceapi.domain.CurrentAccount;
import com.transaction.api.transactionmicroserviceapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
}
