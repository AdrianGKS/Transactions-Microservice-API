package com.transaction.api.transactionmicroserviceapi.dto;

import com.transaction.api.transactionmicroserviceapi.domain.CurrentAccount;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        String name,

        @NotBlank
        CurrentAccountDTO account

) {
}
