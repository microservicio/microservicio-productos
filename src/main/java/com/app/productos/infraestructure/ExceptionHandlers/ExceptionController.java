package com.app.productos.infraestructure.ExceptionHandlers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> internalServerError(Exception exception){
        return new ResponseEntity<>(buildError(exception),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseError> productNotFound(RuntimeException runtimeException){
        return new ResponseEntity<>(buildError(runtimeException),HttpStatus.NOT_FOUND);
    }

    private ResponseError buildError(Throwable throwable){
        return ResponseError.builder().id(generateId())
                .message(throwable.getMessage()).build();
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}

