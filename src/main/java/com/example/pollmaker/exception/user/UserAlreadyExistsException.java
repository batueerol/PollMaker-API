package com.example.pollmaker.exception.user;
/*
This exception occurs when given email or username from user exists.
*/
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
