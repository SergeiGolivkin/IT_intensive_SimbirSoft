package com.simbirsoft.spring_demo.controller;

import antlr.StringUtils;
import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.dto.PublisherDto;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.service.AuthorService;
import com.simbirsoft.spring_demo.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable("id") Long id){
        if (!isEmpty()) {
            Publisher publisher = publisherService.findById(id);

            if (isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(publisher);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



    @PostMapping("/create")
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDto publisherDto){
        if(isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        publisherService.save(publisherDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Publisher publisher = publisherService.findById(id);

        if (isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        publisherService.delete(id);
        return ResponseEntity.ok().build();

    }
}
