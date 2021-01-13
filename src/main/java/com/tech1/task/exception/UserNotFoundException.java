package com.tech1.task.exception;

public class UserNotFoundException extends Exception{

    private static final String DEFAULT_MESSAGE = "user not found";

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        this(DEFAULT_MESSAGE);
    }






}
