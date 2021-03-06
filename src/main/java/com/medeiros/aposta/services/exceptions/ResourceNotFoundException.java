package com.medeiros.aposta.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ResourceNotFoundException(Object email) {
        super("Resource not found " + email);
    }

}
