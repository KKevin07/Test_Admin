package com.example.test_thymeleaf_web.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
//@WebListener//声明为一个监听器
public class MyServletContextListener implements ServletContextListener {   //继承原生的ServletContextListener


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyServletContextListener监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyServletContextListener监听到项目销毁");  //自定义的销毁监听得等到拔电源，也就看不见了
    }
}
