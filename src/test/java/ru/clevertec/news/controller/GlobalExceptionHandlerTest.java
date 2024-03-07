package ru.clevertec.news.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.news.exception.EmptyListException;
import ru.clevertec.news.exception.EntityNotFoundException;
import ru.clevertec.news.exception.InvalidJwtException;
import ru.clevertec.news.exception.NoAccessError;
import ru.clevertec.news.handler.GlobalExceptionHandler;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler controllerAdvice;

    @Test
    void errorShouldReturnEntityNotFoundException() {
        EntityNotFoundException exception = new EntityNotFoundException();
        String message = "Entity not found!";

        var response = controllerAdvice.error(exception);

        assertThat(response.getErrorCode()).isEqualTo(404);
        assertThat(Objects.requireNonNull(response.getErrorMessage())).isEqualTo(message);
    }

    @Test
    void errorShouldReturnEmptyListException() {
        EmptyListException exception = new EmptyListException();
        String message = "List is empty!";

        var response = controllerAdvice.error(exception);

        assertThat(response.getErrorCode()).isEqualTo(404);
        assertThat(Objects.requireNonNull(response.getErrorMessage())).isEqualTo(message);
    }

    @Test
    void errorShouldReturnInvalidJwtException() {
        String message = "Invalid jwt!";
        InvalidJwtException exception = new InvalidJwtException(message);

        var response = controllerAdvice.error(exception);

        assertThat(response.getErrorCode()).isEqualTo(302);
        assertThat(Objects.requireNonNull(response.getErrorMessage())).isEqualTo(message);
    }

    @Test
    void errorShouldReturnNoAccessException() {
        String message = "No access";
        NoAccessError exception = new NoAccessError();

        var response = controllerAdvice.error(exception);

        assertThat(response.getErrorCode()).isEqualTo(403);
        assertThat(Objects.requireNonNull(response.getErrorMessage())).isEqualTo(message);
    }

    @Test
    void handleThrowable() {
        String message = "Error";
        Exception exception = new Exception(message);

        var response = controllerAdvice.handleException(exception);

        assertThat(response.getErrorCode()).isEqualTo(500);
        assertThat(Objects.requireNonNull(response.getErrorMessage())).isEqualTo(message);
    }
}