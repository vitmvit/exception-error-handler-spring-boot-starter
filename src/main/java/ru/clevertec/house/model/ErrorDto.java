package ru.clevertec.house.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDto {

    private final String errorMessage;

    private final Integer errorCode;
}
