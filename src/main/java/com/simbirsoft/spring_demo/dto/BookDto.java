package com.simbirsoft.spring_demo.dto;


import java.time.LocalDate;

public class BookDto {

    private Long authorId;
    private String name;
    private String genre;
    private LocalDate yearOfPublishing;

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(LocalDate yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
