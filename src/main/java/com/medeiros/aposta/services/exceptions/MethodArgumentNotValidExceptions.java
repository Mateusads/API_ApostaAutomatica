package com.medeiros.aposta.services.exceptions;

public class MethodArgumentNotValidExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public MethodArgumentNotValidExceptions(Object email) {
        super("Resorce not found " + email);
    }
}
