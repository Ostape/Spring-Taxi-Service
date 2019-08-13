package com.robosh.model.customExceptions;

/**
 * my own custom exception that should be
 * thrown when email is already exists in database
 * @author Orest Shemelyuk
 */
public class EmailIsAlreadyTaken extends Exception {
    public EmailIsAlreadyTaken() {
    }

    public EmailIsAlreadyTaken(String message) {
        super(message);
    }

    public EmailIsAlreadyTaken(Throwable throwable) {
        super(throwable);
    }

    public EmailIsAlreadyTaken(String message, Throwable throwable) {
        super(message, throwable);
    }
}
