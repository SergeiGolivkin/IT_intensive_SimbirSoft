package com.simbirsoft.spring_demo.service;


import com.simbirsoft.spring_demo.dto.UserDto;
import com.simbirsoft.spring_demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findById(Long id);

    void delete(Long id);

    void save(UserDto userDto);
}
