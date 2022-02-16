package com.store.exceptions;

public class ProductNotInStockException extends Exception{

    public ProductNotInStockException(String message) {
        super(message);
    }
}
