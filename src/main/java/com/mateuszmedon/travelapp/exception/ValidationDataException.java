package com.mateuszmedon.travelapp.exception;

public class ValidationDataException extends RuntimeException {
    public ValidationDataException(String message) {
        super("Invalid data: " + message);
    }
}
