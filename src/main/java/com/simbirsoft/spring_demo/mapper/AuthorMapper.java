package com.simbirsoft.spring_demo.mapper;

import com.simbirsoft.spring_demo.dto.request.CreateAuthorRequest;
import com.simbirsoft.spring_demo.dto.response.AuthorResponse;
import com.simbirsoft.spring_demo.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(CreateAuthorRequest createAuthorRequest);

    AuthorResponse toAuthorResponse(Author author);
}
