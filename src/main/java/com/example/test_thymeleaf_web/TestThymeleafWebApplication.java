package com.example.test_thymeleaf_web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.example.test_thymeleaf_web.mapper")  //简化mapper注解，mapper路径下其他的接口就可以不用标注@Mapper注解，但不推荐（但的确很方便），还是一个一个加更稳妥
@ServletComponentScan(basePackages = "com.example.test_thymeleaf_web")//自动扫描且指定路径（默认扫描路径为主配置类下文件夹），在此路径下，添加的自定义Servlet
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class TestThymeleafWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestThymeleafWebApplication.class, args);
    }

}
