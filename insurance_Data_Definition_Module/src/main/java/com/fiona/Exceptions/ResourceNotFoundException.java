package com.fiona.Exceptions;

public class ResourceNotFoundException  extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
