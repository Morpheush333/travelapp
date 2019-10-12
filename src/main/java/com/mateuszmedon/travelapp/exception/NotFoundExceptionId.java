package com.mateuszmedon.travelapp.exception;

public class NotFoundExceptionId extends RuntimeException {
    public NotFoundExceptionId(String message) {
        super ("Wrong id: " + message);
    }
}
