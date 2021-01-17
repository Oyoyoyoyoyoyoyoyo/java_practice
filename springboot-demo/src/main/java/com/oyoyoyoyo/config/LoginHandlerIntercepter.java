package com.oyoyoyoyo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Date:2021/1/17
 * Decription:<拦截器配置类>
 *
 * @Author:oyoyoyoyoyoyo
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    //判断是否登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object loginUser = request.getSession().getAttribute("loginUser");
        //没有登录
        if (loginUser == null) {
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }
}
