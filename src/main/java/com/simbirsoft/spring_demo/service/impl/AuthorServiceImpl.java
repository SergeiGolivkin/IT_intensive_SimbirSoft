package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.exception.AuthorNotFoundException;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.repository.AuthorRepository;
import com.simbirsoft.spring_demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        Assert.notNull(id, "Author id should not be null");
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Author id should not be null");
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        authorRepository.delete(author);
    }


    @Override
    public Author save(Author author) {
        Assert.notNull(author, "Author dto object should not be null");
        return authorRepository.save(author);

    }
}

