package com.test.controller;

import com.test.dto.AdminLoginDto;
import com.test.service.adminLogin.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class adminLoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    AdminLoginService adminloginService;


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler ) throws Exception{

        System.out.println("Start adminLoginInterceptor session");

        HttpSession session = request.getSession(false);

        if(session != null){
            Object admin = session.getAttribute("adminLogin");
            AdminLoginDto adminLog = (AdminLoginDto) admin;

            System.out.println("session is not null");

            ArrayList<AdminLoginDto> loginInfo = adminloginService.getLoginInfo();
            AdminLoginDto result = loginInfo.get(0);

            System.out.println(adminLog.getId());
            System.out.println(adminLog.getPassword());

            if(adminLog.getId().equals(result.getId()) &&
                    adminLog.getPassword().equals(result.getPassword())){
                return true;

            }else{
                response.sendRedirect("/admin");
                return false;
            }

        }else{
            System.out.println("session is null");
            return false;
        }

    }
}
