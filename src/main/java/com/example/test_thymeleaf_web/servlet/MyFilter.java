package com.example.test_thymeleaf_web.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 自定义拦截器,可以只触发拦截器，具体的拦截操作需要拦截器的doFilter规定，不一定就是拦截路由访问请求，比如本拦截器
 * */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})//拦截路径的设置
                                     // 注意：  /*  是servlet的写法，  /**  是spring的写法
                                    //  使用{} 可以设定多个路径
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter工作");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
