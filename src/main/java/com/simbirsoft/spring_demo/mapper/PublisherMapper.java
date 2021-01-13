package com.simbirsoft.spring_demo.mapper;

import com.simbirsoft.spring_demo.dto.request.CreatePublisherRequest;
import com.simbirsoft.spring_demo.dto.response.PublisherResponse;
import com.simbirsoft.spring_demo.model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toPublisher(CreatePublisherRequest createPublisherRequest);

    PublisherResponse toPublisherResponse(Publisher publisher);
}
