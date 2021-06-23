package com.example.test_thymeleaf_web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 经常会用，以前要在xml里写，现在调用用注解直接写
 * */
//@WebServlet(urlPatterns = "/my") //此种方式若想生效，还需在主配置类Application里加入@ServletComponentScan，以注入容器
                                //这个servlet可以绕过拦截器直接生效，因为拦截器是spring中的对执行方法进行拦截的设定。servlet直接是web服务器支持。
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("666");
    }
}
