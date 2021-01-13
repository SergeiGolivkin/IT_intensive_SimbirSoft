package com.simbirsoft.spring_demo.service.impl;


import com.simbirsoft.spring_demo.exception.PublisherNotFoundException;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.repository.PublisherRepository;
import com.simbirsoft.spring_demo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private PublisherRepository publisherRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        Assert.notNull(id, "Publisher id should not be null");
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "Publisher id should not be null");
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
        publisherRepository.delete(publisher);

    }

    @Override
    public Publisher save(Publisher publisher) {

        Assert.notNull(publisher, "Publisher dto object should not be null");
        return publisherRepository.save(publisher);
    }
}
