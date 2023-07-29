package com.vitospizza.userservice.exception;

public class UserNameAlreadyExistException extends Exception {

    public UserNameAlreadyExistException(String message) {
        super(message);
    }
}
