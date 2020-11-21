package com.simbirsoft.spring_demo.controller;


import com.simbirsoft.spring_demo.dto.PublisherDto;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/publisher")
public final class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable("id") Long id) {
        if (!isEmpty(id)) {
            Publisher publisher = publisherService.findById(id);

            if (isEmpty(publisher)) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(publisher);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDto publisherDto) {
        if (isEmpty(publisherDto)) {
            return ResponseEntity.badRequest().build();
        }
        publisherService.save(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Publisher publisher = publisherService.findById(id);

        if (isEmpty(publisher)) {
            return ResponseEntity.notFound().build();
        }
        publisherService.delete(id);
        return ResponseEntity.ok().build();

    }
}
