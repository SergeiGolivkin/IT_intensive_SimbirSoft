package com.simbirsoft.spring_demo.dto.request;

import com.simbirsoft.spring_demo.model.Publisher;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateAuthorRequest {


    private final Publisher publisher;

    @NotBlank(message = "{\"field\":\"firstName\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 100, message = "{\"field\":\"firstName\", \"message\":\"Поле не должно превышать 100 символов\"}")
    private final String firstName;

    @NotBlank(message = "{\"field\":\"lastName\", \"message\":\"Поле является обязательным\"}")
    private final String lastName;
}
