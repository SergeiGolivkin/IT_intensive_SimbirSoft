package com.simbirsoft.spring_demo.controller;

import com.simbirsoft.spring_demo.dto.request.CreateUserRequest;
import com.simbirsoft.spring_demo.dto.response.UserResponse;
import com.simbirsoft.spring_demo.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface UserController  {

    String USER_ID_PATH_VARIABLE = "/{id}";

    @GetMapping
    @PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "show all users")
    ResponseEntity<List<User>> getAll();

    @PreAuthorize("hasAnyAuthority('user:read')")
    @GetMapping(USER_ID_PATH_VARIABLE)
    @ApiOperation(value = "show user by ID")
    ResponseEntity<UserResponse> findById(@PathVariable("id") Long id);

    @PreAuthorize("hasAnyAuthority('user:write')")
    @PostMapping
    @ApiOperation(value = "create a new user")
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest);

    @PreAuthorize("hasAnyAuthority('user:write')")
    @DeleteMapping(USER_ID_PATH_VARIABLE)
    @ApiOperation(value = "delete user by ID")
    ResponseEntity<String> delete(@PathVariable("id") Long id);
}
