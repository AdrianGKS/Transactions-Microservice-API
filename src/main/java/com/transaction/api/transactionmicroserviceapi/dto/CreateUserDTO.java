package com.transaction.api.transactionmicroserviceapi.dto;

import java.util.List;

public record CreateUserDTO(
        String name,
        String numberAccount,
        Double balance

) {
}
