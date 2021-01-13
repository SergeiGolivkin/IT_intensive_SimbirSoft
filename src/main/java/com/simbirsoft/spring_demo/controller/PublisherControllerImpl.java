package com.simbirsoft.spring_demo.controller;


import com.simbirsoft.spring_demo.Urls;
import com.simbirsoft.spring_demo.dto.request.CreatePublisherRequest;
import com.simbirsoft.spring_demo.dto.response.PublisherResponse;
import com.simbirsoft.spring_demo.mapper.PublisherMapper;
import com.simbirsoft.spring_demo.model.Publisher;
import com.simbirsoft.spring_demo.service.PublisherService;
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
@RequestMapping(Urls.Publishers.FULL)
@Api(value = "Publisher Service", description = "Publisher table")
public class PublisherControllerImpl implements PublisherController {

    private final PublisherService publisherService;
    private final PublisherMapper publisherMapper;

    @Override
    public ResponseEntity<List<Publisher>> getAll() {
        return ResponseEntity.ok(publisherService.getAll());
    }


    @Override
    public ResponseEntity<PublisherResponse> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        Publisher publisher = publisherService.findById(id);



        return ResponseEntity
                .ok(publisherMapper.toPublisherResponse(
                        publisherService.findById(id)));
    }

    @Override
    public ResponseEntity<PublisherResponse> createPublisher(@Valid @RequestBody CreatePublisherRequest createPublisherRequest) {
        if (isEmpty(createPublisherRequest)) {
            return ResponseEntity.badRequest().build();
        }
        publisherMapper.toPublisherResponse(publisherService.save(publisherMapper.toPublisher(createPublisherRequest)));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherMapper.toPublisherResponse(
                        publisherService.save(
                                publisherMapper.toPublisher(createPublisherRequest))));
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
       Publisher publisher = publisherService.findById(id);

        if (isEmpty(publisher)) {
            return ResponseEntity.notFound().build();
        }
        publisherService.delete(id);
        return ResponseEntity.ok().build();

    }

}
