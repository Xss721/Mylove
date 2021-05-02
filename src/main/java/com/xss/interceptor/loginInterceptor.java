package com.xss.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * request 请求参数，获取请求参数，可以通过session获得是否存在用户
 * response 返回参数，若用户未登录  可以通过该参数进行重定向至登录页
 * handle
 *
 * */
@Slf4j
public class loginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("来到了拦截器");
        if (request.getSession().getAttribute("user") == null) {
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }
}
