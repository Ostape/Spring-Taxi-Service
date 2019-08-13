package com.robosh.model.customExceptions;
/**
 * my own custom exception that should be
 * thrown when input password and phone number
 * @author Orest Shemelyuk
 */
public class WrongPasswordOrPhoneNumber extends Exception {
    public WrongPasswordOrPhoneNumber() {
    }

    public WrongPasswordOrPhoneNumber(String message) {
        super(message);
    }

    public WrongPasswordOrPhoneNumber(Throwable throwable) {
        super(throwable);
    }

    public WrongPasswordOrPhoneNumber(String message, Throwable throwable) {
        super(message, throwable);
    }
}
