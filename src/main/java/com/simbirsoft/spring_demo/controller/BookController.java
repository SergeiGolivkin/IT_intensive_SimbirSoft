package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") Long id){
        if (isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Book book = bookService.findById(id);

        if(isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(book);
    }



    @PostMapping("/create")
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto){
        if(isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        bookService.save(bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);

        if (isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.ok().build();

    }

}