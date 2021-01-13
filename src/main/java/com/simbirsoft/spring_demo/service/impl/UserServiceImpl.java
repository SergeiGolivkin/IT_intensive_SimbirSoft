package com.simbirsoft.spring_demo.service.impl;

import com.simbirsoft.spring_demo.exception.BookNotFoundException;
import com.simbirsoft.spring_demo.exception.UserNotFoundException;
import com.simbirsoft.spring_demo.model.Book;
import com.simbirsoft.spring_demo.model.User;
import com.simbirsoft.spring_demo.repository.UserRepository;
import com.simbirsoft.spring_demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        Assert.notNull(id, "User id should not be null");
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        Assert.notNull(id, "User id should not be null");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);

    }

    @Override
    public User save(User user) {

        Assert.notNull(user, "User dto object should not be null");
        return userRepository.save(user);

    }
}
