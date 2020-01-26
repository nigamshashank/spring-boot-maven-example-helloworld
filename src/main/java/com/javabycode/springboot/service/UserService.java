package com.javabycode.springboot.service;

import com.javabycode.springboot.entity.User;

import java.util.List;



public interface UserService {

    //User save(User user);
    List<User> findAll();
    User findOne(long userId);
    /*List<User> findByFirstnameStartingWith(String firstname);
    User update(User user);
    User delete(long user);*/
}
