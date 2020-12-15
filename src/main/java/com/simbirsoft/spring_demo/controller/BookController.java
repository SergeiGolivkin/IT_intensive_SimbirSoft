package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/book")
@Api(value = "Book Service", description = "Book table")
public class BookController {

    private final BookService bookService;

    @GetMapping
    @PreAuthorize("hasAuthority('book:read')")
    @ApiOperation(value = "show all books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }


    @PreAuthorize("hasAnyAuthority('book:read')")
    @GetMapping("/{id}")
    @ApiOperation(value = "show book by ID")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Book book = bookService.findById(id);

        if (isEmpty(book)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(book);
    }

    @PreAuthorize("hasAnyAuthority('book:write')")
    @PostMapping("/create")
    @ApiOperation(value = "create a new book")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        if (isEmpty(bookDto)) {
            return ResponseEntity.badRequest().build();
        }
        bookService.save(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAnyAuthority('book:write')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete book by ID")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);

        if (isEmpty(book)) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.ok().build();

    }

}
