package com.qul.controller;

import com.qul.pojo.User;
import com.qul.result.Result;
import com.qul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List getUserList(){
        return userService.findAll();
    }

    //注册
    @RequestMapping("/reg")
    @ResponseBody
    public Result reg(@RequestBody User user){
        boolean b = checkUsernameIsRepeat(user.getUsername());
        if (b){
            try {
                userService.add(user);
                return new Result(true,"注册成功，请登录邮箱激活");
            } catch (Exception e) {
                return new Result(false,"注册失败");
            }
        }else {
            return new Result(false,"用户名已存在");
        }

    }
    //验证用户名是否重复
    private boolean checkUsernameIsRepeat(String username){
        return userService.checkUsernameIsRepeat(username);
    }
}
