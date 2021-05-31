package com.xss.controller;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
/*
* 全局异常处理，虽然还没有生效
* */
@ControllerAdvice
public class errorController {

    @ExceptionHandler(Exception.class)
    ModelAndView HandlerException(Exception e , HttpRequest request){
        ModelAndView view = new ModelAndView();
        view.setViewName("error.html");
        view.addObject("msg",e.getMessage());
        return view;
    }


}
