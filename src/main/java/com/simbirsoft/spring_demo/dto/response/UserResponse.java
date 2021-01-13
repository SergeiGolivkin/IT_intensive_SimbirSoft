package com.simbirsoft.spring_demo.dto.response;


import com.simbirsoft.spring_demo.model.Role;
import com.simbirsoft.spring_demo.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
}
