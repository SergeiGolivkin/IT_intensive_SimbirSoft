package com.simbirsoft.spring_demo.exception;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(Long id) {
        super("There is not publisher with id: " + id);
    }
}
