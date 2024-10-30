package ru.clevertec.news.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.clevertec.news.exception.*;
import ru.clevertec.news.model.ErrorDto;

/**
 * Обработчик исключений.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение {@link NoAccessError} и возвращает объект ErrorDto с сообщением и кодом состояния 403.
     */
    @ExceptionHandler(NoAccessError.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto error(NoAccessError e) {
        return new ErrorDto(e.getMessage(), HttpStatus.FORBIDDEN.value());
    }

    /**
     * Обрабатывает исключение {@link InvalidJwtException} и возвращает объект ErrorDto с сообщением и кодом состояния 302.
     */
    @ExceptionHandler(InvalidJwtException.class)
    @ResponseStatus(HttpStatus.FOUND)
    public ErrorDto error(InvalidJwtException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.FOUND.value());
    }

    /**
     * Обрабатывает исключение {@link EntityNotFoundException} и возвращает объект ErrorDto с сообщением и кодом состояния 404.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(EntityNotFoundException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    /**
     * Обрабатывает исключение {@link EmptyListException} и возвращает объект ErrorDto с сообщением и кодом состояния 404.
     */
    @ExceptionHandler(EmptyListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto error(EmptyListException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    /**
     * Обрабатывает исключение OperationException и возвращает объект ErrorDto с сообщением и кодом состояния 500.
     */
    @ExceptionHandler(OperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto error(OperationException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    /**
     * Обрабатывает общее исключение Exception и возвращает объект ErrorDto с сообщением и кодом состояния 500.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception e) {
        return new ErrorDto(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}