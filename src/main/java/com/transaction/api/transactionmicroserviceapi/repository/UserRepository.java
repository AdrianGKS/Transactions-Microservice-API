package com.transaction.api.transactionmicroserviceapi.repository;

import com.transaction.api.transactionmicroserviceapi.domain.CurrentAccount;
import com.transaction.api.transactionmicroserviceapi.domain.User;
import com.transaction.api.transactionmicroserviceapi.dto.CurrentAccountDTO;
import com.transaction.api.transactionmicroserviceapi.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
