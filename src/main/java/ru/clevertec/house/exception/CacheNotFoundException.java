package ru.clevertec.house.exception;

public class CacheNotFoundException extends RuntimeException {

    public CacheNotFoundException() {
        super("Cache not found!");
    }
}
