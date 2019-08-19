package com.qul.test;

import com.github.pagehelper.Page;
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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

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
        System.out.println(user);
        user.setAddress("2");
        userService.save(user);
        User one = userService.findOne(1);
        System.out.println(one);
    }
}
