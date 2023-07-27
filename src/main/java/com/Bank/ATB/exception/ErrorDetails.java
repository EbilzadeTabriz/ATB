package com.Bank.ATB.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                           String message,
                           String details
                           ) {

}
