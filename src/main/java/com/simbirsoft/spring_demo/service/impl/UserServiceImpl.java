package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.dto.UserDto;
import com.simbirsoft.spring_demo.mapper.UserMapper;
import com.simbirsoft.spring_demo.model.User;
import com.simbirsoft.spring_demo.repository.UserRepository;
import com.simbirsoft.spring_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(userMapper.toUser(userDto));
    }
}
