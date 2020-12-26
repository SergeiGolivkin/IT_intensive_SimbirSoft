package com.simbirsoft.spring_demo.controller;


import com.simbirsoft.spring_demo.dto.UserDto;
import com.simbirsoft.spring_demo.model.User;
import com.simbirsoft.spring_demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
@Api(value = "User Service", description = "User table")
public class UserController {

    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "show all users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('user:read')")
    @GetMapping("/{id}")
    @ApiOperation(value = "show user by ID")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        if (!isEmpty(id)) {
            User user = userService.findById(id);

            if (isEmpty(user)) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping("/create")
    @ApiOperation(value = "create a new user")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
        if (isEmpty(userDto)) {
            return ResponseEntity.badRequest().build();
        }
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAnyAuthority('user:write')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete user by ID")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);

        if (isEmpty(user)) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(id);
        return ResponseEntity.ok().build();

    }

}
