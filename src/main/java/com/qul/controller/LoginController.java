package com.qul.controller;



import com.alibaba.druid.util.StringUtils;
import com.qul.pojo.ConfigTest;
import com.qul.pojo.User;
import com.qul.result.Result;
import com.qul.service.ConfigTestService;
import com.qul.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConfigTestService configTestService;

    @RequestMapping("/showName")
    @ResponseBody
    public String showName(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return user.getUsername();
    }
    @RequestMapping("/showTime")
    @ResponseBody
    public String showTime(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getLastLoginTime());
    }

    @RequestMapping("/tologin")
    @ResponseBody
    public Result login(@Param("username")String username, @Param("password") String password, HttpServletRequest request) throws NoSuchAlgorithmException, IOException {

        ConfigTest tset = configTestService.findTset();
        if (tset.getKaiguan()==1){
            return new Result(false,"系统维护");
        }

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return new Result(false,"用户名或密码不能为空");
        }

        User user = userService.findByUsername(username);
        if (user==null){
            return new Result(false,"用户名不存在");
        }
        //是否激活
        if (user.getStatus()==0){
            return new Result(false,"用户未激活，请前往邮箱"+user.getEmail()+"激活");
        }
        //验证密码
        BASE64Encoder b64Encoder = new BASE64Encoder();
        String newPassword = b64Encoder.encode(MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8")));
        //是否冻结
        if (user.getFreeze()==1){
            long l = (new Date().getTime() - user.getErrorPasswordTime().getTime()) / (1000 * 60);
            //如果l<=30，提示
            if (l<=30l){
                return new Result(false,"用户已冻结，请"+(30l-l)+"分钟后再登录");
            }
            //密码正确
            if (user.getPassword().equals(newPassword)){
                user.setErrorCount(0);
                user.setFreeze(0);
                user.setLastLoginTime(new Date());
                userService.save(user);
                request.getSession().setAttribute("user",user);
                return new Result(true,"登录成功");
            } else {
                //冻结的情况下，错误次数一定是5次
                user.setErrorPasswordTime(new Date());
                userService.save(user);
                return new Result(false,"用户已冻结，请30分钟后再登录");
            }
        }
        //密码不对
        if (!user.getPassword().equals(newPassword)){
            //如果错误次数小于4，+1
            if (user.getErrorCount()<4){
                user.setErrorCount(user.getErrorCount()+1);
                user.setErrorPasswordTime(new Date());
                userService.save(user);
                return new Result(false,"用户名或密码错误，您还有"+(5-user.getErrorCount())+"次机会");
            }
            if (user.getErrorCount()==4){
                user.setErrorCount(user.getErrorCount()+1);
                user.setFreeze(1);
                user.setErrorPasswordTime(new Date());
                userService.save(user);
                return new Result(false,"用户已冻结，请30分钟后再登录");
            }
        }
        //密码正确，直接登录
        user.setLastLoginTime(new Date());
        userService.save(user);
        request.getSession().setAttribute("user",user);
        return new Result(true,"登录成功");
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

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return new Result(true,"你已经安全退出");
    }
}
