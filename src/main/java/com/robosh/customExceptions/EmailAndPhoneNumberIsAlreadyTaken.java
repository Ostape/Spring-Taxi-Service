package com.robosh.customExceptions;

public class EmailAndPhoneNumberIsAlreadyTaken extends RuntimeException {
    public EmailAndPhoneNumberIsAlreadyTaken() {
    }

    public EmailAndPhoneNumberIsAlreadyTaken(String message) {
        super(message);
    }

    public EmailAndPhoneNumberIsAlreadyTaken(Throwable throwable) {
        super(throwable);
    }

    public EmailAndPhoneNumberIsAlreadyTaken(String message, Throwable throwable) {
        super(message, throwable);
    }
}
