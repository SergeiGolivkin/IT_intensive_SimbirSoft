package com.simbirsoft.spring_demo.mapper;


import com.simbirsoft.spring_demo.dto.request.CreateBookRequest;
import com.simbirsoft.spring_demo.dto.response.BookResponse;
import com.simbirsoft.spring_demo.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toBook(CreateBookRequest createBookRequest);

    BookResponse toBookResponse(Book book);
}
