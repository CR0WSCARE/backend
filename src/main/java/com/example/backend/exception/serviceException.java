package com.example.backend.exception;

public class serviceException extends RuntimeException {
    public serviceException(String message) {
        super(message);
    }
}
