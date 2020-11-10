package com.simbirsoft.spring_demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeyController {

    @GetMapping("/hey")
    public ResponseEntity<String> sayHey() {
        return new ResponseEntity<>("Hey", HttpStatus.OK);
    }
}
