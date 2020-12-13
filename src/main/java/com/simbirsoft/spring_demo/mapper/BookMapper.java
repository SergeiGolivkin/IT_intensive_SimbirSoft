package com.simbirsoft.spring_demo.mapper;

import com.simbirsoft.spring_demo.dto.BookDto;
import com.simbirsoft.spring_demo.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    Book toBook(BookDto bookDto);
}
