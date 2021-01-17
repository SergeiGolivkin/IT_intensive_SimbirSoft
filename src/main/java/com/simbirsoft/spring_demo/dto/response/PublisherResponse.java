package com.simbirsoft.spring_demo.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublisherResponse {

    private String firstName;
    private String lastName;
    private String company;

}
