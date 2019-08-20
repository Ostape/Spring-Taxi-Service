package com.robosh.model.customExceptions;

public class PasswordNotEquals extends RuntimeException {
    public PasswordNotEquals() {
    }

    public PasswordNotEquals(String message) {
        super(message);
    }

    public PasswordNotEquals(Throwable throwable) {
        super(throwable);
    }

    public PasswordNotEquals(String message, Throwable throwable) {
        super(message, throwable);
    }
}
