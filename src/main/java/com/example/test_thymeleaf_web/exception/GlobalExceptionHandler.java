package com.example.test_thymeleaf_web.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web Controller的异常，
 * */
@Slf4j
@ControllerAdvice  //内含conponent，自动添加进容器中
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})    //异常处理器，处理异常
    public String handleArithException(Exception e){

        log.error("异常是：{}",e);
        return "login";// 返回视图地址  （ModelAndView）
    }
}
