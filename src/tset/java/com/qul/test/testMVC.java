package com.qul.test;

import com.github.pagehelper.PageHelper;
import com.qul.pageresult.PageResult;
import com.qul.pojo.Brand;
import com.qul.pojo.ConfigTest;
import com.qul.pojo.User;
import com.qul.service.BrandService;
import com.qul.service.ConfigTestService;
import com.qul.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.BASE64Encoder;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class testMVC {

    @Autowired
    private UserService userService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ConfigTestService configTestService;


    @Test
    public void testfindAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }

    @Test
    public void test1(){
        String s = String.format("%s-%s.txt", "测试", "2019-7-29");
        System.out.println(s);
    }
    @Test
    public void test2(){

        int page=1;
        int size=10;
        PageHelper.startPage(page,size);
        PageResult all = brandService.findAll();
        System.out.println(all);
    }

    @Test
    public void test3() {
        Brand brand = new Brand();
        String a="1";
        String b="10";
        PageResult pageResult = brandService.search(brand, a, b);
        //List<Brand> list = brandService.search(brand);
        System.out.println(pageResult.getRows());
    }

    @Test
    public void test4() {
        ConfigTest tset = configTestService.findTset();
        System.out.println(tset);
    }
    @Test
    public void test5() {
        User user = userService.findOne(1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getLastLoginTime()));
    }

    @Test
    public void test6() {
        String s="111";
        if (null!=s){
            System.out.println(s);
        }
    }

    @Test
    public void test7() {
        User user=null;
        if (user==null){
            System.out.println(111);
        }
    }

    @Test
    public void test8() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String ss="123";
        BASE64Encoder b64Encoder = new BASE64Encoder();
        String s = b64Encoder.encode(MessageDigest.getInstance("MD5").digest(ss.getBytes("UTF-8")));
        System.out.println(s);
    }

    @Test
    public void test9() {
        User user = userService.findOne(1);
        long l = new Date().getTime() - user.getLastLoginTime().getTime();
        System.out.println(l/(1000*60));
    }

    @Test
    public void test10() {
        User user = userService.findOne(1);
        int i = user.getErrorCount();
        user.setErrorCount(10);
        userService.save(user);
        System.out.println(user.getErrorCount());
    }
}
