package com.qul.service.impl;

import com.qul.dao.UserDao;
import com.qul.pojo.User;
import com.qul.service.UserService;
import org.codehaus.plexus.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
    public void add(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //加密
        BASE64Encoder b64Encoder = new BASE64Encoder();
        String AndMD5Password = b64Encoder.encode(MessageDigest.getInstance("MD5").digest(user.getPassword().getBytes("UTF-8")));
        user.setPassword(AndMD5Password);
        user.setErrorPasswordTime(new Date());
        userDao.add(user);
    }

    @Override
    public boolean checkUsernameIsRepeat(String username) {
        int i = 0;
        try {
            i = userDao.checkUsernameIsRepeat(username);
        } catch (Exception e) {

        }
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
