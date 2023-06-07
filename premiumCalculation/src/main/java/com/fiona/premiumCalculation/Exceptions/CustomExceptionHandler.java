package com.fiona.premiumCalculation.Exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class CustomExceptionHandler {
    @ExceptionHandler(DependentsValidationException.class)
    public ResponseEntity<Object> handleDependentsValidationException(DependentsValidationException ex) {
        // Build a custom error response
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());

        // Return the error response with the appropriate HTTP status
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
