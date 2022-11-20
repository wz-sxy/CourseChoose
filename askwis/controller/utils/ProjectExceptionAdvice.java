package com.askwis.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常处理器
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R("服务器故障，请稍后再试");
    }
}
