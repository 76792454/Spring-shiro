package com.example.springsecuritydemo.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.AuthenticationException;

//全局异常处理器进行处理全局异常
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthenticationException.class)
    public ModelAndView error(AuthenticationException e){
        ModelAndView modelAndView = new ModelAndView("unauthorized");
        modelAndView.addObject("error",e.getMessage());
        return modelAndView;
    }
}
