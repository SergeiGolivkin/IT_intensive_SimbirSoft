package com.simbirsoft.spring_demo.service;


import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;

public interface BookService {

    Book findById(Long id);

    void delete(Long id);

    void save(BookDto bookDto);
}
