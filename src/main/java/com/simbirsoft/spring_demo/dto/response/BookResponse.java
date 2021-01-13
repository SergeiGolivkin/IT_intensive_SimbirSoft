package com.simbirsoft.spring_demo.dto.response;

import com.simbirsoft.spring_demo.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BookResponse {

    private final Long id;
    private final Author author;
    private final String name;
    private final String genre;
    private final LocalDate yearOfPublishing;
}
