package com.simbirsoft.spring_demo.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("There is not user with id: " + id);
    }
}
