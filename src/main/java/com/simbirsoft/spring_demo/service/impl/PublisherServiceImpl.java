package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.dto.PublisherDto;
import com.simbirsoft.spring_demo.mapper.PublisherMapper;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.repository.PublisherRepository;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublisherMapper publisherMapper;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public void save(PublisherDto publisherDto) {
        publisherRepository.save(publisherMapper.toPublisher(publisherDto));

    }
}
