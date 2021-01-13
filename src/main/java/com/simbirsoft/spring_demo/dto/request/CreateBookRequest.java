package com.simbirsoft.spring_demo.dto.request;

import com.simbirsoft.spring_demo.model.Author;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
public class CreateBookRequest {


    private final Author author;

    @NotBlank(message = "{\"field\":\"name\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 100, message = "{\"field\":\"name\", \"message\":\"Поле не должно превышать 100 символов\"}")
    private String name;

    @NotBlank(message = "{\"field\":\"genre\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 100, message = "{\"field\":\"genre\", \"message\":\"Поле не должно превышать 100 символов\"}")
    private String genre;

    @NotBlank(message = "{\"field\":\"yearOfPublishing\", \"message\":\"Поле является обязательным\"}")
    private LocalDate yearOfPublishing;
}
