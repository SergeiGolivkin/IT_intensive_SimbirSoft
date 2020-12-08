package com.simbirsoft.spring_demo.service;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.model.Author;
import java.util.List;

public interface AuthorService {

    List<Author> getAll();

    Author findById(Long id);

    void delete(Long id);

    void save(AuthorDto authorDto);
}

