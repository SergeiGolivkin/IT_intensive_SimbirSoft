package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PreAuthorize("hasAnyAuthority('book:read')")
    @GetMapping("/{id}")
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
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        if (isEmpty(bookDto)) {
            return ResponseEntity.badRequest().build();
        }
        bookService.save(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PreAuthorize("hasAnyAuthority('book:write')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);

        if (isEmpty(book)) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.ok().build();

    }

}
