package com.robosh.customExceptions;

public class NoSuchDriverOrderException extends RuntimeException {
    public NoSuchDriverOrderException() {
    }

    public NoSuchDriverOrderException(String message) {
        super(message);
    }

    public NoSuchDriverOrderException(Throwable throwable) {
        super(throwable);
    }

    public NoSuchDriverOrderException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
