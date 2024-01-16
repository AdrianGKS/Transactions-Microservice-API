package com.transaction.api.transactionmicroserviceapi.dto;



public record TransactionDTO(
        Long id,
        Double value,
        UserDTO origin,
        UserDTO destiny
) {
}
