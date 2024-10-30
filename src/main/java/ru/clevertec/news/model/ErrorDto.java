package ru.clevertec.news.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Класс, представляющий объект ошибки.
 */
@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDto {

    private final String errorMessage;

    private final Integer errorCode;
}