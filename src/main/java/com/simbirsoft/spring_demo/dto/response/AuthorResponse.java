package com.simbirsoft.spring_demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorResponse {

    private final Long publisherId;
    private final String firstName;
    private final String lastName;
}
