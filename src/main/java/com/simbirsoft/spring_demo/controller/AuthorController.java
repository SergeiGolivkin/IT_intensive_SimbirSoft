package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.AuthorDto;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/author")
@Api(value = "Author Service", description = "Author table")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    @PreAuthorize("hasAuthority('author:read')")
    @ApiOperation(value = "show all authors")
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('author:read')")
    @GetMapping("/{id}")
    @ApiOperation(value = "show author by ID")
    public ResponseEntity<Author> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Author author = authorService.findById(id);

        if (isEmpty(author)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(author);
    }


    @PreAuthorize("hasAnyAuthority('author:write')")
    @PostMapping("/create")
    @ApiOperation(value = "create a new author")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        if (isEmpty(authorDto)) {
            return ResponseEntity.badRequest().build();
        }
        authorService.save(authorDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAnyAuthority('author:write')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete author by ID")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Author author = authorService.findById(id);

        if (isEmpty(author)) {
            return ResponseEntity.notFound().build();
        }
        authorService.delete(id);
        return ResponseEntity.ok().build();

    }
}
