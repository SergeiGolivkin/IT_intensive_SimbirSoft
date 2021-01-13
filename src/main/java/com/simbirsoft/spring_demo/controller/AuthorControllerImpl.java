package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.Urls;
import com.simbirsoft.spring_demo.dto.request.CreateAuthorRequest;
import com.simbirsoft.spring_demo.dto.response.AuthorResponse;
import com.simbirsoft.spring_demo.mapper.AuthorMapper;
import com.simbirsoft.spring_demo.model.Author;
import com.simbirsoft.spring_demo.service.AuthorService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping(Urls.Authors.FULL)
@Api(value = "Author Service", description = "Author table")
public class AuthorControllerImpl implements AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @Override
    public ResponseEntity<List<Author>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @Override
    public ResponseEntity<AuthorResponse> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Author author = authorService.findById(id);



        return ResponseEntity
                .ok(authorMapper.toAuthorResponse(
                        authorService.findById(id)));
    }


    @Override
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody CreateAuthorRequest createAuthorRequest) {
        if (isEmpty(createAuthorRequest)) {
            return ResponseEntity.badRequest().build();
        }
        authorMapper.toAuthorResponse(authorService.save(authorMapper.toAuthor(createAuthorRequest)));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authorMapper.toAuthorResponse(
                        authorService.save(
                                authorMapper.toAuthor(createAuthorRequest))));

    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Author author = authorService.findById(id);

        if (isEmpty(author)) {
            return ResponseEntity.notFound().build();
        }
        authorService.delete(id);
        return ResponseEntity.ok().build();

    }
}
