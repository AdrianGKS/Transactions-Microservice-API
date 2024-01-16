package com.transaction.api.transactionmicroserviceapi.dto;


import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String numberAccount,
        Double balance,
        List<TransactionDTO> transactions

) {
}
