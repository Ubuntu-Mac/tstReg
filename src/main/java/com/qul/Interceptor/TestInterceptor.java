package com.qul.Interceptor;

import com.qul.pojo.ConfigTest;
import com.qul.result.Result;
import com.qul.service.ConfigTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class TestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ConfigTestService configTestService;

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {

        /*String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!name.equals("qul")){
            ConfigTest tset = configTestService.findTset();
            if (tset!=null && tset.getKaiguan()==1){
                String s = request.getRequestURI().split("/")[1];
                if (s.equalsIgnoreCase("login")){
                    return false;
                }
                if (s.equalsIgnoreCase("brand")){
                    response.sendRedirect("/page/home.html");
                }
            }
        }*/
        return true;
    }
}
