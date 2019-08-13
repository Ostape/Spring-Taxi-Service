package com.robosh.model.customExceptions;
/**
 * my own custom exception that should be
 * thrown when phone number is already exists in database
 * @author Orest Shemelyuk
 */
public class PhoneNumberIsAlreadyTaken extends Exception {
    public PhoneNumberIsAlreadyTaken() {
    }

    public PhoneNumberIsAlreadyTaken(String message) {
        super(message);
    }

    public PhoneNumberIsAlreadyTaken(Throwable throwable) {
        super(throwable);
    }

    public PhoneNumberIsAlreadyTaken(String message, Throwable throwable) {
        super(message, throwable);
    }
}
