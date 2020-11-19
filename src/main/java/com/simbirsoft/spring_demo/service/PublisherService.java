package com.simbirsoft.spring_demo.service;


import com.simbirsoft.spring_demo.dto.PublisherDto;
import com.simbirsoft.spring_demo.model.Publisher;

public interface PublisherService {

    Publisher findById(Long id);

    void delete(Long id);

    void save(PublisherDto publisherDto);
}
