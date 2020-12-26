package com.simbirsoft.spring_demo.dto;

import com.simbirsoft.spring_demo.model.Role;
import com.simbirsoft.spring_demo.model.Status;
import lombok.Data;

@Data
public class UserDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;

}
