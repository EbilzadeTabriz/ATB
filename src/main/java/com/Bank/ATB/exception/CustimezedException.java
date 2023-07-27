package com.Bank.ATB.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
@ControllerAdvice
@Slf4j
public class CustimezedException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)

    public final ResponseEntity<Object> handleException1(Exception ex, WebRequest request) throws Exception{
        ErrorDetails errorDetails =
                new ErrorDetails(LocalDateTime.now(),
                        ex.getMessage(),
                        request.getDescription(false));
        log.error("User not found");
        log.info("information not found");
        return new ResponseEntity<>(errorDetails,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleArgumentException(MethodArgumentNotValidException ex) {

        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public final ResponseEntity<Object> handleAllException(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
                ex.getMessage(),
                null);

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}


