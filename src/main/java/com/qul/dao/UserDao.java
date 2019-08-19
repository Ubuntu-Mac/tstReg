package com.qul.dao;

import com.qul.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void add(User user);

    int checkUsernameIsRepeat(String username);

    User findByUsername(String username);

    void save(User user);

    User findOne(int id);
}
