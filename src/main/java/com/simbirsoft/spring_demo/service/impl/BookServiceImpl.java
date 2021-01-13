package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.exception.BookNotFoundException;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.repository.BookRepository;
import com.simbirsoft.spring_demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Book findById(Long id) {
        Assert.notNull(id,"Book id should not be null");
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id,"Book id should not be null");
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.delete(book);

    }

    @Override
    public Book save(Book book) {

        Assert.notNull(book,"Book dto object should not be null");
        return bookRepository.save(book);
    }
}
