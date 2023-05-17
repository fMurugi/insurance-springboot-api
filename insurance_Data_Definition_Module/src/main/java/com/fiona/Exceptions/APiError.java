package com.fiona.Exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
public class APiError {
    private String message;
    private HttpStatus status;
     private LocalDateTime timeStamp;
}
