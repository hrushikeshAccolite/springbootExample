package com.Product.prod.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus
public class ProductException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
