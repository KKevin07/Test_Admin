package com.example.test_thymeleaf_web.config;


import com.example.test_thymeleaf_web.interceptor.LoginInterceptor;
//import com.example.test_thymeleaf_web.interceptor.RedisUrlCountInterceptor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


/**
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）  // 当前类为  注册拦截器   ，拦截器的编写见interceptor,,ll,,,
 * 3.指定拦截规则，（如果是拦截所有，静态资源也会被拦截）
 *
 * @EnableWebMvc : 全面接管WebMvc(即全面重写，全部的MVC配置都要自己写，不能随便加@EnableWebMvc)
 *          1.  静态资源？视图解析器？欢迎页？。。。。。。。。全部失效
 * */
//@EnableWebMvc   一定慎用
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * Filter\Interceptor 几乎拥有相同的功能，（用哪个好？）
     * Filter是Servlet定义的原生组件，脱离Spring应用也能使用
     * Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能
     */
//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;

    /**
     * 定义静态资源行为
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /**
//         * 访问  /aa/**  的所有请求  都去"classpath:/static/" 下面进行匹配
//         * */
//        registry.addResourceHandler("/aa/**")
//                .addResourceLocations("classpath:/static/");
//    }


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")    //拦截哪些,"/**"为拦截所有请求，静态资源也会被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**","/city","/sql");   //除此之外，放行哪些请求

//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/aa/**");

    }

    //还未完全掌握RequestMappingHandlerMapping原理时，不建议重写自定义
//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//       return new WebMvcRegistrations(){
//           @Override
//           public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//               return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
//           }
//       };
//    }
}
