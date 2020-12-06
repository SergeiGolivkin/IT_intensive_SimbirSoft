package com.simbirsoft.spring_demo.controller;


import com.simbirsoft.spring_demo.dto.PublisherDto;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    @Autowired
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('publisher:read')")
    public ResponseEntity<List<Publisher>> getAll() {
        return ResponseEntity.ok(publisherService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('publisher:read')")
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


    @PreAuthorize("hasAnyAuthority('publisher:write')")
    @PostMapping("/create")
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDto publisherDto) {
        if (isEmpty(publisherDto)) {
            return ResponseEntity.badRequest().build();
        }
        publisherService.save(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAnyAuthority('publisher:write')")
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
