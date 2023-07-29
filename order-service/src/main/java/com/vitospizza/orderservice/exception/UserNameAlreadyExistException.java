package com.vitospizza.orderservice.exception;

public class UserNameAlreadyExistException extends Exception {

    public UserNameAlreadyExistException(String message) {
        super(message);
    }
}
