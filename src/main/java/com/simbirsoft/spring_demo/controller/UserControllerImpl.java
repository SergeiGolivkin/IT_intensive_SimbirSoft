package com.simbirsoft.spring_demo.controller;


import com.simbirsoft.spring_demo.Urls;
import com.simbirsoft.spring_demo.dto.request.CreateUserRequest;
import com.simbirsoft.spring_demo.dto.response.UserResponse;
import com.simbirsoft.spring_demo.mapper.UserMapper;
import com.simbirsoft.spring_demo.model.User;
import com.simbirsoft.spring_demo.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@AllArgsConstructor
@RestController
@RequestMapping(Urls.Users.FULL)
@Api(value = "User Service", description = "User table")
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }


    @Override
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long id) {
        if (isEmpty(id)) {
            return ResponseEntity.badRequest().build();
        }
        User user  = userService.findById(id);



        return ResponseEntity
                .ok(userMapper.toUserResponse(
                        userService.findById(id)));
    }

    @Override
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        if (isEmpty(createUserRequest)) {
            return ResponseEntity.badRequest().build();
        }
        userMapper.toUserResponse(userService.save(userMapper.toUser(createUserRequest)));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toUserResponse(
                        userService.save(
                                userMapper.toUser(createUserRequest))));
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);

        if (isEmpty(user)) {
            return ResponseEntity.notFound().build();
        }
        userService.delete(id);
        return ResponseEntity.ok().build();

    }


}
