package com.qul.controller;


import com.qul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showName")
    @ResponseBody
    public String showName(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }
    @RequestMapping("/showTime")
    @ResponseBody
    public String showTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = simpleDateFormat.format(date);
        return data;
    }

    @RequestMapping("/login")
    public String login( String username){
        return null;
    }


    @RequestMapping("/img")
    @ResponseBody
    public String img(String image){
        return image;
    }

    @RequestMapping("/file")
    @ResponseBody
    public String file(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()){
            try {
                // 转存文件
                file.transferTo(new File("D:\\test\\"+file.getName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "文件为空";
    }
}
