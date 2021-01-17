package com.simbirsoft.spring_demo.dto.request;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreatePublisherRequest {

    @NotBlank(message = "{\"field\":\"firstName\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"firstName\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String firstName;

    @NotBlank(message = "{\"field\":\"lastName\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"lastName\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String lastName;

    @NotBlank(message = "{\"field\":\"company\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"company\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String company;
}
