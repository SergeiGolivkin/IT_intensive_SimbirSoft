package com.simbirsoft.spring_demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {

    private Long authorId;
    private String name;
    private String genre;
    private LocalDate yearOfPublishing;

}
