package com.transaction.api.transactionmicroserviceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TransactionDTO(
        Long id,
        Double value,
        UserDTO origin,
        UserDTO destiny
) {
}
