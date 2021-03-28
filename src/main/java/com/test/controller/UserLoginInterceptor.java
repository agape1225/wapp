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
        UserDto userDto = (UserDto) session.getAttribute("userLogin");

        if(userDto == null) {
            response.sendRedirect("/user/login");
            return false;
        }

        return true;

    }
}
