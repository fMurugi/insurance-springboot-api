package com.fiona.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import java.time.LocalDateTime;

@ControllerAdvice
class InsuranceTypeExceptions {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleInsuranceTypeNotFound(ResourceNotFoundException ex , WebRequest request){
        return  new ResponseEntity<>(new APiError(ex.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()),HttpStatus.NOT_FOUND);
    }
}
