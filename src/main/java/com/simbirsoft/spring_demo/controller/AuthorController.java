package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.request.CreateAuthorRequest;
import com.simbirsoft.spring_demo.dto.response.AuthorResponse;
import com.simbirsoft.spring_demo.model.Author;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface AuthorController {

    String AUTHOR_ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    @PreAuthorize("hasAuthority('author:read')")
    @ApiOperation(value = "show all authors")
    ResponseEntity<List<Author>> getAll();

    @PreAuthorize("hasAnyAuthority('author:read')")
    @GetMapping(AUTHOR_ID_PATH_VARIABLE)
    @ApiOperation(value = "show author by ID")
    ResponseEntity<AuthorResponse> findById(@PathVariable("id") Long id);

    @PreAuthorize("hasAnyAuthority('author:write')")
    @PostMapping
    @ApiOperation(value = "create a new author")
    ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest);

    @PreAuthorize("hasAnyAuthority('author:write')")
    @DeleteMapping(AUTHOR_ID_PATH_VARIABLE)
    @ApiOperation(value = "delete author by ID")
    ResponseEntity<String> delete(@PathVariable("id") Long id);

}
