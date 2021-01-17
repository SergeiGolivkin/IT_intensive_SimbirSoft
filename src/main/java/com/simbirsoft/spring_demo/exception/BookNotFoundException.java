package com.simbirsoft.spring_demo.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("There is not book with id: " + id);
    }
}
