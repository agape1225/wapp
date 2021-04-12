package com.test.controller;

import com.test.dto.UserDto;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        Object user = session.getAttribute("userLogin");
        if(user == null) {
            System.out.println("로그인 정보가 없습니다.");
            response.sendRedirect("/user/login");
            return false;
        }

        return true;

    }
}
