package com.transaction.api.transactionmicroserviceapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransactionDTO(
        @NotBlank
        UserDTO user,
        @NotNull
        Double value,
        @NotBlank
        CurrentAccountDTO origin,
        @NotBlank
        CurrentAccountDTO destiny
) {
}
