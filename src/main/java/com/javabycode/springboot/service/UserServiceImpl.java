package com.javabycode.springboot.service;

import com.javabycode.springboot.entity.User;
import com.javabycode.springboot.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.slf4j.Logger;

public class UserServiceImpl {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> findAll() {
        LOGGER.debug("Retrieving the list of all users");
        return (List<User>) userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findOne(long id) throws Exception {
        LOGGER.debug("Retrieving a user by user id={}", id);
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new Exception(
                    String.format("No user exists with id=%d", id));
        }
        return user;
    }
}
