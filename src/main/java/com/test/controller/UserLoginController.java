package com.test.controller;

import com.test.dto.UserDto;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;

@Controller
public class UserLoginController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @GetMapping("/user/login")
    public String userLogin(Model model){
        return "userLogin";
    }

    @RequestMapping("/user/login")
    public String userCheck(@RequestParam String userEmail,
                            @RequestParam String userPw){
        System.out.println("email: " + userEmail);
        System.out.println("password: " + userPw);
        UserDto userDto = userService.readUserInfoListByUserEmail(userEmail);
        if(userDto != null && userDto.getUserEmail().equals(userEmail) && userDto.getUserPw().equals(userPw))
            return "redirect:/";
        else
            return "redirect:/user/login";
    }
}