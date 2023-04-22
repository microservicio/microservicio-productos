package com.app.productos.infraestructure.ExceptionHandlers;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){
        super(message);
    }
}
