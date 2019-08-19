package com.qul.service.impl;

import com.qul.dao.UserDao;
import com.qul.pojo.User;
import com.qul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        List<User> all = userDao.findAll();
        return all;
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public boolean checkUsernameIsRepeat(String username) {
        int i = userDao.checkUsernameIsRepeat(username);
        if (i==0){
            return true;
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }
}
