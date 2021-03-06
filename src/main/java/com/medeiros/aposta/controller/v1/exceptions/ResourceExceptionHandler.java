package com.medeiros.aposta.controller.v1.exceptions;

import com.medeiros.aposta.services.exceptions.ConstraintViolationExceptions;
import com.medeiros.aposta.services.exceptions.MethodArgumentNotValidExceptions;
import com.medeiros.aposta.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resorceNotFound(ResourceNotFoundException e,
                                                         HttpServletRequest request) {
        String error = "Resource not Found ";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(ConstraintViolationExceptions.class)
    public ResponseEntity<StandardError> invalidResource(ConstraintViolationExceptions e,
                                                         HttpServletRequest request) {
        String error = "Invalid resource ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidExceptions.class)
    public ResponseEntity<StandardError> invalidResource(MethodArgumentNotValidException e,
                                                         HttpServletRequest request) {
        String error = "Invalid resource ";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}


