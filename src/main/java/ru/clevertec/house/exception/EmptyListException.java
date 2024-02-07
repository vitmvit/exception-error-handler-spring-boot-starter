package ru.clevertec.house.exception;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        super("List is empty!");
    }
}
