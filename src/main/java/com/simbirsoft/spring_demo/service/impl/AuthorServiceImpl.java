package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.mapper.AuthorMapper;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.repository.AuthorRepository;
import com.simbirsoft.spring_demo.service.AuthorService;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private  PublisherService publisherService;

    @Autowired
    private  AuthorMapper authorMapper;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }


    @Override
    public void save(AuthorDto authorDto) {
        authorRepository.save(authorMapper.toAuthor(authorDto));

    }
}

