package com.example.test_thymeleaf_web.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
/**  现有两类servlet
 * 1.自定义Myservlet -->  /my
 * 2.DispatcherServlet  -->  / (主程序类下所有路径)
 *
 *
 * */

//(proxyBeanMethods = false) 不能开启，否则将造成多个对象的建立，随之注入多个组件，造成冗余
//(proxyBeanMethods = true)  默认开启为true,可以保证依赖的组件始终是单实例的
@Configuration(proxyBeanMethods = true)//RegistrationBean 方式进行servlet的注入
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();

        //return new FilterRegistrationBean(myFilter,myServlet());
        // 第一种，默认的函数，两个参数为（1.拦截器，2.要拦截的路径（此处为myServlet()的所有路径））

        //第二种方式
        FilterRegistrationBean filterRegistrationBean =new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }

}
