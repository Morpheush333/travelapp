package com.mateuszmedon.travelapp.controller;


import com.mateuszmedon.travelapp.exception.NotFoundExceptionId;
import com.mateuszmedon.travelapp.exception.ValidationDataException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ValidationDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handlerValidationException(ValidationDataException exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @ExceptionHandler(NotFoundExceptionId.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleNotFoundException(NotFoundExceptionId exception) {
        return new ErrorMessage(exception.getMessage());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class ErrorMessage {
        private String message;
    }
}
