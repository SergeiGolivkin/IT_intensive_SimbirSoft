package com.simbirsoft.spring_demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMassage {

    private final String status;
    private final String message;

}
