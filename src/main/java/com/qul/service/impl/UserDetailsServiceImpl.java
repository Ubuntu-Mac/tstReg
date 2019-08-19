package com.qul.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.qul.pojo.User user = userService.findByUsername(username);
        List<GrantedAuthority> list =new ArrayList<>();

        list.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        if (user!=null){
            Date date=new Date();
            user.setLastLoginTime(date);
            userService.save(user);
            return new User(username,user.getPassword(),list);
        } else {
            return null;
        }
    }
}
