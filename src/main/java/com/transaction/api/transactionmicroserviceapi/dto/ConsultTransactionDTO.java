package com.transaction.api.transactionmicroserviceapi.dto;


import java.time.LocalDate;

public record ConsultTransactionDTO(
        UserDTO userDTO,
        Double value,
        LocalDate date
) {
}
