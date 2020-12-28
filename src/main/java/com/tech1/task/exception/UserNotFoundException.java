package com.tech1.task.exception;

public class UserNotFoundException extends Exception{

    private static final String DEFAULT_MESSAGE = "user not found";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }






}
