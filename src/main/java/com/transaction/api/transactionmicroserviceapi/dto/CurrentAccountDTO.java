package com.transaction.api.transactionmicroserviceapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CurrentAccountDTO(

        @NotBlank
        String numberAccount
) {
}
