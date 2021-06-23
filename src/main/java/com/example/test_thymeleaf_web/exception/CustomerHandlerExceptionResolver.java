package com.example.test_thymeleaf_web.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义  直接发送错误请求的异常处理器,实际上在异常处理器排序的最底层，但可以指定优先级
 * */
//@Order(value = Ordered.HIGHEST_PRECEDENCE)  //设定最高优先级，整型数字越小，优先级越高
@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        try {
            httpServletResponse.sendError(511,"自定义的错误，处于最底层，当前优先级为默认");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return new ModelAndView();
    }
}
