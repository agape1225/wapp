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
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/deleteuser", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "userNo") String userNo) {

        try {
            System.out.println("userNo: " + userNo);
            userService.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }

    @GetMapping(value = "/user")
    public String readUserInfoList(Model model){
        try{
            System.out.println("user Controller");
            ArrayList<UserDto> userList =  userService.readUserInfoList();
            if(userList.size() > 5){
                while(userList.size() > 5){
                    userList.remove(0);
                }
            }
            model.addAttribute("userList", userList);
            System.out.println("end manageLecture");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "user";
    }

//    @GetMapping(value = "/user")
//    public String readUserInfoListByUserNo(@RequestParam(value = "userNo", required = false) String userNo, Model model){
//        UserDto user =  userService.readUserInfoListByUserNo(userNo);
//        model.addAttribute("user_detail", user);
//
//        return "user";
//    }
}
