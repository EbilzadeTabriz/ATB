package com.Bank.ATB.dto;

import jakarta.validation.constraints.*;

public record MoneyRequestResponse(

        @NotNull(message = "fullname bull olmamalidir")
        @NotEmpty(message = "bos olmamamalidir")
        @NotBlank(message ="bosluq olmamamlidir" )
                @Email(message = "email olmalidir")
                @Size(max = 8,message = "max 8 olmalidir")
        String fullname,
        String TypeOfMoney
) {
}
