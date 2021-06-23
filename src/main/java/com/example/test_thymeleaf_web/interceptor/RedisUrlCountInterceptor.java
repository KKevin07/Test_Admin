package com.example.test_thymeleaf_web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component   //Redis 已断开连接，停用redis 路由计数
//public class RedisUrlCountInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//
//        //默认每次访问当前uri   则计数加一
//        redisTemplate.opsForValue().increment(uri);
//
//        return true;
//    }
//}
