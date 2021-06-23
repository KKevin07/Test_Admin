package com.example.test_thymeleaf_web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//添加自定义@ResponseStatus
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
//底层中sponseStatusExceptionResolve会直接将此注解信息作为信息让底层发送/error请求，/error中的错误信息则为该@ResponseStatus的数据

public class UserTooManyException extends RuntimeException{
    public UserTooManyException(){

    }

    public UserTooManyException(String message){
        super(message);
    }
}
