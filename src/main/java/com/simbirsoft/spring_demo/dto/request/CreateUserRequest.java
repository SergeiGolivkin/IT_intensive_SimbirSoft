package com.simbirsoft.spring_demo.dto.request;


import com.simbirsoft.spring_demo.model.Role;
import com.simbirsoft.spring_demo.model.Status;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class CreateUserRequest {

    @NotBlank(message = "{\"field\":\"email\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"email\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String email;

    @NotBlank(message = "{\"field\":\"password\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"password\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String password;

    @NotBlank(message = "{\"field\":\"firstName\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"firstName\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String firstName;

    @NotBlank(message = "{\"field\":\"lastName\", \"message\":\"Поле является обязательным\"}")
    @Size(max = 30, message = "{\"field\":\"lastName\", \"message\":\"Поле не должно превышать 30 символов\"}")
    private String lastName;

    @NotBlank(message = "{\"field\":\"role\", \"message\":\"Поле является обязательным\"}")
    private Role role;

    @NotBlank(message = "{\"field\":\"status\", \"message\":\"Поле является обязательным\"}")
    private Status status;


}
