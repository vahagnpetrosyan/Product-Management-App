package com.products.products.exceptionhandling.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private String message;

    public ProductNotFoundException (String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
