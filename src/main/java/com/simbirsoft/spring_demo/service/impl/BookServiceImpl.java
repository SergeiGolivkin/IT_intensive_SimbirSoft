package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.repository.BookRepository;
import com.simbirsoft.spring_demo.service.AuthorService;
import com.simbirsoft.spring_demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }


    @Override
    public void save(BookDto bookDto) {
        Book book = new Book();
        book.setAuthor(authorService.findById(bookDto.getAuthorId()));
        book.setName(bookDto.getName());
        book.setGenre(bookDto.getGenre());
        book.setYearOfPublishing(bookDto.getYearOfPublishing());
        bookRepository.save(book);


    }
}
