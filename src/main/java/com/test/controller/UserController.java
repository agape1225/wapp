package com.test.controller;

import com.test.dto.BannerDto;
import com.test.dto.UserDto;
import com.test.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    ServletContext servletContext;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/login/userDelete", method = RequestMethod.GET)
    public String delete(@RequestParam(value = "userNo") String userNo) {

        try {
            System.out.println("userNo: " + userNo);
            userService.deleteUser(userNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }

    @GetMapping(value = "/user/login/userList")
    public String readUserInfoList(Model model){
        ArrayList<UserDto> userList =  userService.readUserInfoList();
        model.addAttribute("userList", userList);

        return "user/login/userList";
    }

    @GetMapping(value = "/user/login/user_data")
    public String readUserInfoListByUserNo(@RequestParam(value = "userNo") String userNo, Model model){
        UserDto user =  userService.readUserInfoListByUserNo(userNo);
        model.addAttribute("user_detail", user);

        return "user/login/user_data";
    }


}
