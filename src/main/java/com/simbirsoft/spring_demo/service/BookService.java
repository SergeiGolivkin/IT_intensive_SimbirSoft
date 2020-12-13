package com.simbirsoft.spring_demo.service;


import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book findById(Long id);

    void delete(Long id);

    void save(BookDto bookDto);
}
