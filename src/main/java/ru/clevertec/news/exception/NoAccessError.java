package ru.clevertec.news.exception;

public class NoAccessError extends RuntimeException {

    public NoAccessError() {
        super("No access");
    }
}