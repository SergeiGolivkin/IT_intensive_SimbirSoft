package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable("id") Long id){
        if (isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Author author = authorService.findById(id);

        if(isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(author);
    }



    @PostMapping("/create")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto){
        if(isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        authorService.save(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Author author = authorService.findById(id);

        if (isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        authorService.delete(id);
        return ResponseEntity.ok().build();

    }
}
