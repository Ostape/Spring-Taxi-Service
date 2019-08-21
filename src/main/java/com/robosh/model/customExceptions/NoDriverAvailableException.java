package com.robosh.model.customExceptions;

public class NoDriverAvailableException extends RuntimeException {
    public NoDriverAvailableException() {
    }

    public NoDriverAvailableException(String message) {
        super(message);
    }

    public NoDriverAvailableException(Throwable throwable) {
        super(throwable);
    }

    public NoDriverAvailableException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
