package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.request.CreateBookRequest;
import com.simbirsoft.spring_demo.dto.response.BookResponse;
import com.simbirsoft.spring_demo.model.Book;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;
import java.util.List;

public interface BookController {

    String BOOK_ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    @PreAuthorize("hasAuthority('book:read')")
    @ApiOperation(value = "show all books")
    ResponseEntity<List<Book>> getAll();

    @PreAuthorize("hasAnyAuthority('book:read')")
    @GetMapping(BOOK_ID_PATH_VARIABLE)
    @ApiOperation(value = "show book by ID")
    ResponseEntity<BookResponse> findById(@PathVariable("id") Long id);

    @PreAuthorize("hasAnyAuthority('book:write')")
    @PostMapping
    @ApiOperation(value = "create a new book")
    ResponseEntity<BookResponse> createBook(@Valid @RequestBody CreateBookRequest createBookRequest);

    @PreAuthorize("hasAnyAuthority('book:write')")
    @DeleteMapping(BOOK_ID_PATH_VARIABLE)
    @ApiOperation(value = "delete book by ID")
    ResponseEntity<String> delete(@PathVariable("id") Long id);

}
