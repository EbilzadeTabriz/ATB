package com.Bank.ATB.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @Email
        String email,
        @Size(min = 7)
        String password
) {
}
