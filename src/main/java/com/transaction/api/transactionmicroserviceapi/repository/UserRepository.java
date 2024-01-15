package com.transaction.api.transactionmicroserviceapi.repository;

import com.transaction.api.transactionmicroserviceapi.domain.User;
import com.transaction.api.transactionmicroserviceapi.dto.CreateUserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
    select u from User u where u.numberAccount = :numberAccount
    """)
    String findByNumberAccount(@Param("numberAccount") String numberAccount);
}
