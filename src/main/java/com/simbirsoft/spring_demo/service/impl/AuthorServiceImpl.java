package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.repository.AuthorRepository;
import com.simbirsoft.spring_demo.service.AuthorService;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherService publisherService;

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
        Author author = new Author();
        author.setPublisher(publisherService.findById(authorDto.getPublisherId()));
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        authorRepository.save(author);

    }
}

