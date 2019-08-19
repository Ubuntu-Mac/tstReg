package com.qul.service;

import com.qul.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void add(User user);

    boolean checkUsernameIsRepeat(String username);

    User findByUsername(String username);

    void save(User user);
}
