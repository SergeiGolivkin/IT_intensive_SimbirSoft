package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.Urls;
import com.simbirsoft.spring_demo.dto.request.CreateBookRequest;
import com.simbirsoft.spring_demo.dto.response.BookResponse;
import com.simbirsoft.spring_demo.mapper.BookMapper;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.service.BookService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping(Urls.Books.FULL)
@Api(value = "Book Service", description = "Book table")
public class BookControllerImpl implements BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    @Override
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }


    @Override
    public ResponseEntity<BookResponse> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Book book = bookService.findById(id);



        return ResponseEntity
                .ok(bookMapper.toBookResponse(
                        bookService.findById(id)));
    }

    @Override
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody CreateBookRequest createBookRequest) {
        if (isEmpty(createBookRequest)) {
            return ResponseEntity.badRequest().build();
        }
        bookMapper.toBookResponse(bookService.save(bookMapper.toBook(createBookRequest)));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(bookMapper.toBookResponse(
                        bookService.save(
                                bookMapper.toBook(createBookRequest))));
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Book book = bookService.findById(id);

        if (isEmpty(book)) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.ok().build();

    }

}
