package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.request.CreatePublisherRequest;
import com.simbirsoft.spring_demo.dto.response.PublisherResponse;
import com.simbirsoft.spring_demo.model.Publisher;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface PublisherController {

    String PUBLISHER_ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    @PreAuthorize("hasAuthority('publisher:read')")
    @ApiOperation(value = "show all publishers")
    ResponseEntity<List<Publisher>> getAll();

    @PreAuthorize("hasAnyAuthority('publisher:read')")
    @GetMapping(PUBLISHER_ID_PATH_VARIABLE)
    @ApiOperation(value = "show publisher by ID")
    ResponseEntity<PublisherResponse> findById(@PathVariable("id") Long id);

    @PreAuthorize("hasAnyAuthority('publisher:write')")
    @PostMapping
    @ApiOperation(value = "create a new publisher")
    ResponseEntity<PublisherResponse> createPublisher(@Valid @RequestBody CreatePublisherRequest createPublisherRequest);

    @PreAuthorize("hasAnyAuthority('publisher:write')")
    @DeleteMapping(PUBLISHER_ID_PATH_VARIABLE)
    @ApiOperation(value = "delete publisher by ID")
    ResponseEntity<String> delete(@PathVariable("id") Long id);

}
