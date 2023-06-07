package com.fiona.premiumCalculation.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;


    public ErrorResponse() {

    }

    public ErrorResponse(String message, HttpStatus httpStatus, LocalDateTime now) {
    }
}
