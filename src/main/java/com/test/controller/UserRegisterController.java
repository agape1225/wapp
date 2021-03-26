package com.test.controller;

import com.test.dto.UserDto;
import com.test.dto.UserInsertDto;
import com.test.dto.UserRegisterDto;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserRegisterController {

    @Autowired
    UserService userService;

    @GetMapping ("/user/register")
    public String registerUserView() {
        return "userRegister";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String registerUser(UserRegisterDto userRegisterDto){

        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);

        UserInsertDto userDto = new UserInsertDto(
                userRegisterDto.getUserName(),
                userRegisterDto.getUserEmail(),
                userRegisterDto.getUserPw(),
                date
        );

        System.out.println("control " + userDto.toString());

        userService.insertUser(userDto);

        System.out.println("insert userDto success");
        return "redirect:/user/login";
    }


}