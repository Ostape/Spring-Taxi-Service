package com.robosh.model.customExceptions;

public class NoDriverAvaluableException extends RuntimeException {
    public NoDriverAvaluableException() {
    }

    public NoDriverAvaluableException(String message) {
        super(message);
    }

    public NoDriverAvaluableException(Throwable throwable) {
        super(throwable);
    }

    public NoDriverAvaluableException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
