package ru.clevertec.house.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.house.exception.EmptyListException;
import ru.clevertec.house.exception.EntityNotFoundException;
import ru.clevertec.house.exception.InvalidJwtException;
import ru.clevertec.house.model.ErrorDto;

/**
 * Обработчик исключений.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidJwtException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ErrorDto error(InvalidJwtException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.FOUND.value());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(EntityNotFoundException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(EmptyListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(EmptyListException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto error(RuntimeException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception e) {
        return new ErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
