package com.simbirsoft.spring_demo.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("There is not author with id: " + id);
    }
}
