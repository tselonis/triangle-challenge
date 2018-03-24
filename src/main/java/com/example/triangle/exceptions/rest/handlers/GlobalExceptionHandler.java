package com.example.triangle.exceptions.rest.handlers;

import com.example.triangle.response.rest.GeneralErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public GeneralErrorResponse handle(ConstraintViolationException exception) {
        return new GeneralErrorResponse(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
    }
}
