package com.qul.fiflter;


import com.qul.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFiflter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String uri = request.getRequestURI();

        if (uri.contains("login") || uri.contains("reg") || uri.contains("plugins") || uri.contains("css") || uri.contains("img")|| uri.contains("404")) {
            filterChain.doFilter(request, response); // 放行
            return;
        }

        HttpSession session = request.getSession();
        User user =  (User) session.getAttribute("user");
        //禁止浏览器缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", -1);
        if (user==null){
            response.sendRedirect("/login.html");
        } else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
