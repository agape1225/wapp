package com.test.controller;

import com.test.dto.UserDto;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String user(Model model){
        return "login";
    }

    @GetMapping("/user/login")
    public String userLogin(Model model){
        return "userLogin";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String userCheck(HttpServletRequest request, Model model,
                            @RequestParam String userEmail,
                            @RequestParam String userPw){

        HttpSession session = request.getSession();

        if(session.getAttribute("userLogin") != null)
            session.removeAttribute("userLogin");

        System.out.println("email: " + userEmail);
        System.out.println("password: " + userPw);

        UserDto userDto = userService.readUserInfoListByUserEmail(userEmail);
        if(userDto != null && userDto.getUserEmail().equals(userEmail) && userDto.getUserPw().equals(userPw)) {
            session.setAttribute("userLogin", userDto);
            return "redirect:/";
        }
        else {
            model.addAttribute("msg", "사용자의 id 혹은 패스워드가 일치하지 않습니다.");
            return "userLogin";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}