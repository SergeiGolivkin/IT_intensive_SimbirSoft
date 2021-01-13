package com.simbirsoft.spring_demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.hibernate.internal.util.StringHelper.isBlank;

@ControllerAdvice
@Slf4j
public class ExceptionController extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorMassage message = new ErrorMassage("Error", extractError(ex));
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorMassage message = new ErrorMassage("Error", extractError(ex));
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<ErrorMassage> handleAuthorNotFoundException(AuthorNotFoundException e) {
        log.trace("Author not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMassage("Error", extractError(e)));
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMassage> handleBookNotFoundException(BookNotFoundException e) {
        log.trace("Book not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMassage("Error", extractError(e)));
    }

    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity<ErrorMassage> handlePublisherNotFoundException(PublisherNotFoundException e) {
        log.trace("Publisher not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMassage("Error", extractError(e)));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMassage> handleUserNotFoundException(UserNotFoundException e) {
        log.trace("User not found", e);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMassage("Error", extractError(e)));
    }

    private String extractError(Exception e) {
        return isBlank(e.getMessage()) ? e.getClass().getCanonicalName() : e.getMessage();
    }
}
