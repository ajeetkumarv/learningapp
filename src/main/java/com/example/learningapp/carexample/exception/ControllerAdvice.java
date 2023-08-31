package com.example.learningapp.carexample.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void carNotFound() {}

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<String> invalidInputPathVariableRequestParam(ConstraintViolationException exception) {
        logger.info("handling exception: ConstraintViolationException", exception);
        return exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();
    }
}
